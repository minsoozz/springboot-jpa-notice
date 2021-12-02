package com.example.notice.model.response;

import com.querydsl.core.annotations.QueryProjection;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
public class NoticeResponseDto implements Serializable {

  private String title;
  private String content;
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime createDate;
  private int views;
  private String writer;

  @QueryProjection
  public NoticeResponseDto(String title, String content, LocalDateTime createDate, int views,
      String writer) {
    this.title = title;
    this.content = content;
    this.createDate = createDate;
    this.views = views;
    this.writer = writer;
  }
}
