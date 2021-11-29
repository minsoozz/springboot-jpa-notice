package com.example.notice.controller;

import com.example.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notices")
@RequiredArgsConstructor
public class NoticeController {

  private final NoticeService noticeService;

  @PostMapping("")
  public void insertNotice() {

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
