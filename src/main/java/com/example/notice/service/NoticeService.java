package com.example.notice.service;


import com.example.notice.entity.Notice;
import com.example.notice.exception.NoticeNotFoundException;
import com.example.notice.model.request.NoticeInsertRequestDto;
import com.example.notice.model.request.NoticeUpdateRequestDto;
import com.example.notice.model.response.NoticeResponseDto;
import com.example.notice.repository.AttachmentsRepository;
import com.example.notice.repository.NoticeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {

  private final NoticeRepository noticeRepository;
  private final AttachmentsRepository attachmentsRepository;
  private final AttachmentsService attachmentsService;

  public void insertNotice(NoticeInsertRequestDto noticeInsertRequestDto) {
    Notice notice = noticeInsertRequestDto.toEntity(noticeInsertRequestDto);
    noticeRepository.save(notice);
    if (!ObjectUtils.isEmpty(noticeInsertRequestDto.getAttachments())) {
      attachmentsService.insertAttachments(notice, noticeInsertRequestDto.getAttachments());
    }

  }


  public NoticeResponseDto selectNotice(Long id) {
    NoticeResponseDto noticeResponseDto = noticeRepository.selectNotice(id).orElseThrow(NoticeNotFoundException::new);
    noticeResponseDto.updateAttachments(attachmentsRepository.selectAttachmentsByNoticeId(noticeResponseDto.getId()));
    incrementNoticeViews(id);

    return noticeResponseDto;
  }

  @Transactional
  public void deleteNotice(Long id) {
    List<Long> attachmentsIdList = attachmentsRepository.selectAttachmentsIdListByNoticeId(id);
    attachmentsRepository.deleteByNoticeIdInQuery(attachmentsIdList);
    noticeRepository.deleteByIdInQuery(id);
  }

  @Transactional
  public NoticeResponseDto updateNotice(Long id, NoticeUpdateRequestDto noticeUpdateRequestDto) {
    Notice notice = noticeRepository.findById(id).orElseThrow(NoticeNotFoundException::new);
    notice.updateTitleAndContent(noticeUpdateRequestDto.getTitle(), noticeUpdateRequestDto.getContent());
    attachmentsService.updateAttachments(notice, noticeUpdateRequestDto.getTobeDeletedAttachments());
    attachmentsService.insertAttachments(notice, noticeUpdateRequestDto.getAttachments());

    return noticeRepository.selectNotice(id).orElseThrow(NoticeNotFoundException::new);
  }

  public void incrementNoticeViews(Long id) {
    Notice notice = noticeRepository.findById(id).orElseThrow(NoticeNotFoundException::new);
    notice.incrementViews();
  }
}
