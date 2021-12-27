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

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {

  private final NoticeRepository noticeRepository;
  private final AttachmentsRepository attachmentsRepository;
  private final AttachmentsService attachmentsService;

  public void insertNotice(NoticeInsertRequestDto noticeInsertRequestDto) {
    Notice notice = noticeInsertRequestDto.toEntity(noticeInsertRequestDto);
    attachmentsService.insertAttachments(notice, noticeInsertRequestDto.getAttachmentsList());
  }

  public NoticeResponseDto selectNotice(Long id) {
    NoticeResponseDto noticeResponseDto = noticeRepository.selectNotice(id).orElseThrow(NoticeNotFoundException::new);
    noticeResponseDto.updateAttachmentsList(
        attachmentsRepository.selectAttachmentsByNoticeId(noticeResponseDto.getId()));

    return noticeResponseDto;
  }

  @Transactional
  public void deleteNotice(Long id) {
    List<Long> attachmentsIdList = attachmentsRepository.selectAttachmentsIdListByNoticeId(id);
    attachmentsRepository.deleteByNoticeIdInQuery(attachmentsIdList);
    noticeRepository.deleteByIdInQuery(id);
  }

  @Transactional
  public void updateNotice(Long id, NoticeUpdateRequestDto noticeUpdateRequestDto) {
    Notice notice = noticeRepository.findById(id).orElseThrow(NoticeNotFoundException::new);
    notice.updateTitleAndContent(noticeUpdateRequestDto.getTitle(), noticeUpdateRequestDto.getContent());
    attachmentsService.updateAttachments(notice, noticeUpdateRequestDto.getTobeDeletedAttachmentsList());
    attachmentsService.insertAttachments(notice, noticeUpdateRequestDto.getAttachmentsList());
  }
}
