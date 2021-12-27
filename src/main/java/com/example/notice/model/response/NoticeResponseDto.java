package com.example.notice.model.response;

import com.example.notice.model.dto.CommonDto;
import com.querydsl.core.annotations.QueryProjection;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeResponseDto extends CommonDto implements Serializable {

  private static final long serialVersionUID = -2610313256584265021L;

  private Long id;
  private String title;
  private String content;
  private int views;
  private String writer;
  private List<AttachmentsResponseDto> attachmentsList = new ArrayList<>();

  @QueryProjection
  public NoticeResponseDto(LocalDateTime createdDate, Long id, String title, String content, int views, String writer) {
    super(createdDate);
    this.id = id;
    this.title = title;
    this.content = content;
    this.views = views;
    this.writer = writer;
  }

  public void updateAttachmentsList(List<AttachmentsResponseDto> attachmentsResponseDtoList) {
    this.attachmentsList = attachmentsResponseDtoList;
  }
}
