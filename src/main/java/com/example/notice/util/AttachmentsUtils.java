package com.example.notice.util;

import com.example.notice.model.dto.AttachmentsDto;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class AttachmentsUtils {

  @Value("${spring.servlet.multipart.location}")
  private String path;

  public List<AttachmentsDto> convertingMultipartFileToDtoList(
      List<MultipartFile> multipartFileList) {

    List<AttachmentsDto> attachmentsDtoList = new ArrayList<>();

    if (!CollectionUtils.isEmpty(multipartFileList)) {

      for (MultipartFile multipartFile : multipartFileList) {

        AttachmentsDto attachmentsDto = AttachmentsDto
            .builder()
            .originalName(multipartFile.getOriginalFilename())
            .systemName(multipartFile.getOriginalFilename() + UUID.randomUUID())
            .path(path)
            .volume(multipartFile.getSize())
            .build();
        attachmentsDtoList.add(attachmentsDto);

        File file = new File(path + File.separator + multipartFile.getOriginalFilename());

        try {
          multipartFile.transferTo(file);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return attachmentsDtoList;
  }
}
