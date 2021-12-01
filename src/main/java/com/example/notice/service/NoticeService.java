package com.example.notice.service;


import com.example.notice.entity.Attachments;
import com.example.notice.entity.Notice;
import com.example.notice.model.dto.AttachmentsDto;
import com.example.notice.model.request.NoticeRequestDto;
import com.example.notice.repository.AttachmentsRepository;
import com.example.notice.repository.NoticeRepository;
import com.example.notice.util.AttachmentsUtils;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {

  private final NoticeRepository noticeRepository;
  private final AttachmentsRepository attachmentsRepository;
  private final AttachmentsUtils attachmentsUtils;

  public void insertNotice(NoticeRequestDto noticeRequestDto, List<MultipartFile> attachmentsList) {

    Notice notice = noticeRequestDto.toEntity(noticeRequestDto);
    List<AttachmentsDto> attachmentsDtoList = attachmentsUtils.convertingMultipartFileToDtoList(attachmentsList);

    if (!attachmentsDtoList.isEmpty()) {
      for (AttachmentsDto attachmentsDto : attachmentsDtoList) {
        Attachments attachments = attachmentsDto.toEntity(attachmentsDto);
        notice.addAttachments(attachmentsRepository.save(attachments));
      }
    }
    noticeRepository.save(notice);
  }
}
