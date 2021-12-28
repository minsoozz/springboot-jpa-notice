package com.example.notice.model.response;

import com.example.notice.model.dto.CodeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultResponse<T> {

  private int code;
  private String message;
  private T data;

  public ResultResponse(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public ResultResponse<?> successResponse(T data) {
    this.code = CodeType.SUCCESS.getCode();
    this.message = CodeType.SUCCESS.getMessage();
    this.data = data;
    return new ResultResponse<>(this.code, this.message, this.data);
  }
}
