package com.example.notice.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AttachmentNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -3026298808865013973L;

  public AttachmentNotFoundException(String cause) {
    super(cause);
  }
}
