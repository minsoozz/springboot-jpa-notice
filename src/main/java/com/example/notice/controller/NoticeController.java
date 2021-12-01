package com.example.notice.controller;

import com.example.notice.model.request.NoticeRequestDto;
import com.example.notice.service.NoticeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/notices")
@RequiredArgsConstructor
public class NoticeController {

  private final NoticeService noticeService;

  @PostMapping("")
  public void insertNotice(
      @RequestPart(value = "attachmentsList") List<MultipartFile> attachmentsList,
      @RequestPart(value = "noticeRequestDto") NoticeRequestDto noticeRequestDto) {

    noticeService.insertNotice(noticeRequestDto, attachmentsList);
  }

  @GetMapping("/{id}")
  public void selectNotice(@PathVariable Long id) {

  }

  @PutMapping("/{id}")
  public void updateNotice(@PathVariable Long id) {

  }

  @DeleteMapping("/{id}")
  public void deleteNotice(@PathVariable Long id) {

  }
}
