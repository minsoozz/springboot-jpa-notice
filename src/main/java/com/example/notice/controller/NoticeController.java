package com.example.notice.controller;

import com.example.notice.model.request.NoticeInsertRequestDto;
import com.example.notice.model.request.NoticeUpdateRequestDto;
import com.example.notice.model.response.ResultResponse;
import com.example.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
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

  @PostMapping
  public void insertNotice(NoticeInsertRequestDto noticeInsertRequestDto) {
    noticeService.insertNotice(noticeInsertRequestDto);
  }

  @GetMapping("/{id}")
  @Cacheable(key = "#id", value = "selectNotice")
  public ResultResponse<?> selectNotice(@PathVariable Long id) {
    return new ResultResponse<>().successResponse(noticeService.selectNotice(id));
  }

  @PutMapping("/{id}")
  public void updateNotice(@PathVariable Long id, NoticeUpdateRequestDto noticeUpdateRequestDto) {
    noticeService.updateNotice(id, noticeUpdateRequestDto);
  }

  @DeleteMapping("/{id}")
  public void deleteNotice(@PathVariable Long id) {
    noticeService.deleteNotice(id);
  }
}
