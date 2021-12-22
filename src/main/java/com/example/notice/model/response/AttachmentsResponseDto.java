package com.example.notice.model.response;

import com.example.notice.model.dto.CommonDto;
import com.querydsl.core.annotations.QueryProjection;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AttachmentsResponseDto extends CommonDto implements Serializable {

  private static final long serialVersionUID = 7580364008055447034L;

  private String originalName;
  private Long volume;

  @QueryProjection
  public AttachmentsResponseDto(LocalDateTime createdDate, String originalName, Long volume) {
    super(createdDate);
    this.originalName = originalName;
    this.volume = volume;
  }
}
