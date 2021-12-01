package com.example.notice.model.request;

import com.example.notice.entity.Notice;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoticeRequestDto implements Serializable {

  private String title;
  private String content;
  private LocalDate startDate;
  private LocalDate endDate;
  private String writer;

  public Notice toEntity(NoticeRequestDto noticeRequestDto) {
    return Notice
        .builder()
        .title(noticeRequestDto.getTitle())
        .content(noticeRequestDto.getContent())
        .startDate(noticeRequestDto.getStartDate())
        .endDate(noticeRequestDto.getEndDate())
        .writer(noticeRequestDto.writer)
        .build();
  }
}
