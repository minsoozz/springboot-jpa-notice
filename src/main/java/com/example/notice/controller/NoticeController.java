package com.example.notice.controller;

import com.example.notice.model.request.NoticeRequestDto;
import com.example.notice.model.response.NoticeResponseDto;
import com.example.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notices")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    //TODO:: VO 객체로 변경
    @PostMapping
    public void insertNotice(@RequestBody NoticeRequestDto noticeRequestDto) {
        /*noticeService.insertNotice(noticeRequestDto, attachmentsList);*/
    }

    @GetMapping("/{id}")
    public NoticeResponseDto selectNotice(@PathVariable Long id) {
        return noticeService.selectNotice(id);
    }

    @PutMapping("/{id}")
    public void updateNotice(@PathVariable Long id) {
    }

    @DeleteMapping("/{id}")
    public void deleteNotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);
    }
}
