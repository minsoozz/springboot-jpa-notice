package com.example.notice.model.request;

import com.example.notice.entity.Notice;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeRequestDto implements Serializable {

  private static final long serialVersionUID = -8366073361742189237L;

  private String title;
  private String content;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
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
