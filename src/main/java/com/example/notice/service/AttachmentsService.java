package com.example.notice.service;

import com.example.notice.model.dto.AttachmentsDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class AttachmentsService {

    @Value("${spring.servlet.multipart.location}")
    private String path;

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
}
