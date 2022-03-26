package com.example.notice.service;

import com.example.notice.entity.Attachments;
import com.example.notice.entity.Notice;
import com.example.notice.exception.AttachmentNotFoundException;
import com.example.notice.model.dto.AttachmentsDto;
import com.example.notice.repository.AttachmentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AttachmentsService {

  @Value("${spring.servlet.multipart.location}")
  private String path;
  private final AttachmentsRepository attachmentsRepository;

  public void insertAttachments(Notice notice, List<MultipartFile> multipartFileList) {
    for (MultipartFile multipartFile : multipartFileList) {
      //TODO:: MultipartFile -> DTO -> Entity 과정이 맘에 들지 않음, MultipartFile -> Entity 과정이 가능한지
      AttachmentsDto attachmentsDto = multipartFileToDto(multipartFile);
      Attachments attachments = attachmentsDto.toEntity(attachmentsDto);
      notice.addAttachments(attachmentsRepository.save(attachments));
      insertMultipartFile(multipartFile, attachmentsDto.getSystemName());
    }
  }


  public void updateAttachments(Notice notice, List<Long> tobeDeletedAttachmentsList) {
    for (Long attachmentsId : tobeDeletedAttachmentsList) {
      Attachments attachments = attachmentsRepository.findById(attachmentsId)
          .orElseThrow(AttachmentNotFoundException::new);
      notice.deleteAttachments(attachments);
      deleteAttachments(path, attachments.getSystemName());
    }
  }

  public AttachmentsDto multipartFileToDto(MultipartFile multipartFile) {

    String uuid = UUID.randomUUID().toString();
    return AttachmentsDto.of(multipartFile, path, uuid);
  }

  public void insertMultipartFile(MultipartFile multipartFile, String uuid) {
    File file = new File(path + File.separator + uuid);
    try {
      multipartFile.transferTo(file);
    } catch (IOException e) {
      //TODO:: Exception 처리가 깔끔하지 못하다.
      e.printStackTrace();
    }
  }

  public boolean deleteAttachments(String path, String systemName) {
    Path filePath = FileSystems.getDefault().getPath(path, systemName);
    try {
      Files.delete(filePath);
    } catch (IOException | SecurityException e) {
      return false;
    }
    return true;
  }
}
