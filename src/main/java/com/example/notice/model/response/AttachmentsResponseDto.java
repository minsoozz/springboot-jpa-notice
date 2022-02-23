package com.example.notice.model.response;

import com.example.notice.model.dto.CommonDto;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AttachmentsResponseDto extends CommonDto implements Serializable {

  private static final long serialVersionUID = 7580364008055447034L;

  private Long id;
  private String originalName;

  @QueryProjection
  public AttachmentsResponseDto(LocalDateTime createdDate, Long id, String originalName) {
    super(createdDate);
    this.id = id;
    this.originalName = originalName;
  }
}
