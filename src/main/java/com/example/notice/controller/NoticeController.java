package com.example.notice.controller;

import com.example.notice.model.request.NoticeRequestDto;
import com.example.notice.model.response.NoticeResponseDto;
import com.example.notice.model.response.ResultResponse;
import com.example.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notices")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @PostMapping
    public void insertNotice(NoticeRequestDto noticeRequestDto) {
        noticeService.insertNotice(noticeRequestDto);
    }

    @GetMapping("/{id}")
    public ResultResponse<?> selectNotice(@PathVariable Long id) {
        return new ResultResponse<>().successResponse(noticeService.selectNotice(id));
    }

    @PutMapping("/{id}")
    public void updateNotice(@PathVariable Long id) {
    }

    @DeleteMapping("/{id}")
    public void deleteNotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);
    }
}
