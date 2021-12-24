package com.example.notice.config;

import com.example.notice.exception.NoticeNotFoundException;
import com.example.notice.model.dto.CodeType;
import com.example.notice.model.response.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionControllerAdvice {

    @ExceptionHandler(NoticeNotFoundException.class)
    public ResultResponse noticeNotFoundException() {
        return new ResultResponse(CodeType.NOTICE_NOT_FOUND.getCode(), CodeType.NOTICE_NOT_FOUND.getMessage());
    }
}
