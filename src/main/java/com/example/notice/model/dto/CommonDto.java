package com.example.notice.model.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
public abstract class CommonDto {

  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime createdDate;

  public CommonDto(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }
}
