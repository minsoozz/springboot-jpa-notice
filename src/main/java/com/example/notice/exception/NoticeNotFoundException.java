package com.example.notice.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoticeNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 2095453925401290605L;

  public NoticeNotFoundException(String cause) {
    super(cause);
  }
}
