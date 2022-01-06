package com.example.notice.controller;

import com.example.notice.model.request.NoticeInsertRequestDto;
import com.example.notice.model.request.NoticeUpdateRequestDto;
import com.example.notice.model.response.NoticeResponseDto;
import com.example.notice.model.response.ResultResponse;
import com.example.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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
  @Cacheable(key = "#id", value = "notice")
  public ResultResponse<?> selectNotice(@PathVariable Long id) {
    NoticeResponseDto noticeResponseDto = noticeService.selectNotice(id);
    noticeService.incrementNoticeViews(noticeResponseDto.getId());
    return new ResultResponse<>().successResponse(noticeResponseDto);
  }

  @PutMapping("/{id}")
  @CachePut(key = "#id", value = "notice")
  public NoticeResponseDto updateNotice(@PathVariable Long id, NoticeUpdateRequestDto noticeUpdateRequestDto) {
    return noticeService.updateNotice(id, noticeUpdateRequestDto);
  }

  @DeleteMapping("/{id}")
  @CacheEvict(key = "#id", value = "notice")
  public void deleteNotice(@PathVariable Long id) {
    noticeService.deleteNotice(id);
  }
}
