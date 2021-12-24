package com.example.notice.config;

import com.example.notice.exception.NoticeNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    private static final String NOTICE_NOT_FOUND_MESSAGE = "게시글이 존재하지 않습니다";

    @ExceptionHandler(NoticeNotFoundException.class)
    public String noticeNotFoundException() {
        return NOTICE_NOT_FOUND_MESSAGE;
    }
}
