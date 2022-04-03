package com.example.notice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeType {
  SUCCESS(200, "게시글 조회에 성공하였습니다"),
  CREATED(201, "게시글 등록에 성공하였습니다"),
  UPDATE(204, "게시글 수정에 성공하였습니다"),
  DELETE(204, "게시글 삭제에 성공하였습니다"),
  NOTICE_NOT_FOUND(404, "존재하지 않는 게시글입니다"),
  ATTACHMENT_NOT_FOUND(601, "존재하지 않는 첨부파일 입니다");

  private final int code;
  private final String message;
}
