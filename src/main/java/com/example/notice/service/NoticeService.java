package com.example.notice.service;


import com.example.notice.entity.Attachments;
import com.example.notice.entity.Notice;
import com.example.notice.exception.NoticeNotFoundException;
import com.example.notice.model.dto.AttachmentsDto;
import com.example.notice.model.request.NoticeRequestDto;
import com.example.notice.model.response.NoticeResponseDto;
import com.example.notice.repository.AttachmentsRepository;
import com.example.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final AttachmentsRepository attachmentsRepository;
    private final AttachmentsService attachmentsService;

    public void insertNotice(NoticeRequestDto noticeRequestDto) {
        Notice notice = noticeRequestDto.toEntity(noticeRequestDto);

        if (!ObjectUtils.isEmpty(noticeRequestDto.getAttachmentsList())) {
            for (MultipartFile multipartFile : noticeRequestDto.getAttachmentsList()) {

                //TODO:: MultipartFile -> DTO -> Entity 과정이 맘에 들지 않음, MultipartFile -> Entity 과정이 가능한지
                AttachmentsDto attachmentsDto = attachmentsService.multipartFileToDto(multipartFile);
                Attachments attachments = attachmentsDto.toEntity(attachmentsDto);
                notice.addAttachments(attachmentsRepository.save(attachments));
                attachmentsService.insertMultipartFile(multipartFile, attachmentsDto.getSystemName());
            }
        }
        noticeRepository.save(notice);
    }

    public NoticeResponseDto selectNotice(Long id) {
        NoticeResponseDto noticeResponseDto = noticeRepository.selectNotice(id).orElseThrow(NoticeNotFoundException::new);
        noticeResponseDto.updateAttachmentsList(attachmentsRepository.selectAttachmentsByNoticeId(noticeResponseDto.getId()));

        return noticeResponseDto;
    }

    public void deleteNotice(Long id) {
        noticeRepository.deleteById(id);
    }
}
