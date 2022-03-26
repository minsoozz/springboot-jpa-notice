package com.example.notice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeType {
  SUCCESS(200, "조회에 성공하였습니다"),
  NOTICE_NOT_FOUND(600, "존재하지 않는 게시글입니다"),
  ATTACHMENT_NOT_FOUND(601, "존재하지 않는 첨부파일 입니다");
  private int code;
  private String message;
}

