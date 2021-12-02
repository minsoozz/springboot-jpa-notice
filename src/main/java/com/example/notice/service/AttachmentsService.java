package com.example.notice.service;

import com.example.notice.model.dto.AttachmentsDto;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentsService {

  @Value("${spring.servlet.multipart.location}")
  private String path;

  public List<AttachmentsDto> convertingMultipartFileToDtoList(List<MultipartFile> multipartFileList) {

    List<AttachmentsDto> attachmentsDtoList = new ArrayList<>();

    if (!CollectionUtils.isEmpty(multipartFileList)) {
      for (MultipartFile multipartFile : multipartFileList) {
        String uuid = UUID.randomUUID().toString();
        attachmentsDtoList.add(AttachmentsDto.of(multipartFile, path, uuid));
        createFile(multipartFile, uuid);
      }
    }
    return attachmentsDtoList;
  }

  private void createFile(MultipartFile multipartFile, String uuid) {
    File file = new File(path + File.separator + uuid);
    try {
      multipartFile.transferTo(file);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
