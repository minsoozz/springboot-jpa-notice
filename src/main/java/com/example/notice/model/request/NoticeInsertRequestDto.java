package com.example.notice.model.request;

import com.example.notice.entity.Notice;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class NoticeInsertRequestDto implements Serializable {

  private static final long serialVersionUID = -8366073361742189237L;

  private String title;
  private String content;
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime startDate;
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime endDate;
  private String writer;
  private List<MultipartFile> attachmentsList = new ArrayList<>();

  public Notice toEntity(NoticeInsertRequestDto noticeInsertRequestDto) {
    return Notice
        .builder()
        .title(noticeInsertRequestDto.getTitle())
        .content(noticeInsertRequestDto.getContent())
        .startDate(noticeInsertRequestDto.getStartDate())
        .endDate(noticeInsertRequestDto.getEndDate())
        .writer(noticeInsertRequestDto.getWriter())
        .build();
  }
}
