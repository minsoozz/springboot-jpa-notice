package com.example.notice.service;


import com.example.notice.entity.Attachments;
import com.example.notice.entity.Notice;
import com.example.notice.model.dto.AttachmentsDto;
import com.example.notice.model.request.NoticeRequestDto;
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

  public void insertNotice(NoticeRequestDto noticeRequestDto) {
    Notice notice = noticeRequestDto.toEntity(noticeRequestDto);
    List<AttachmentsDto> attachmentsDtoList = attachmentsService.convertingMultipartFileToDtoList(
        noticeRequestDto.getAttachmentsList());

    if (!attachmentsDtoList.isEmpty()) {
      for (AttachmentsDto attachmentsDto : attachmentsDtoList) {
        Attachments attachments = attachmentsDto.toEntity(attachmentsDto);
        notice.addAttachments(attachmentsRepository.save(attachments));
      }
    }
    noticeRepository.save(notice);
  }

  public NoticeResponseDto selectNotice(Long id) {
    NoticeResponseDto noticeResponseDto = noticeRepository.selectNotice(id);
    if (isNoticeId(noticeResponseDto.getId())) {
      noticeResponseDto.updateAttachmentsList(
          attachmentsRepository.selectAttachmentsByNoticeId(noticeResponseDto.getId()));
    }
    return noticeResponseDto;
  }

  public void deleteNotice(Long id) {
    noticeRepository.deleteById(id);
  }

  private boolean isNoticeId(Long id) {
    return id != null;
  }
}
