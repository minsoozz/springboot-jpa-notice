package com.example.notice.model.dto;

import com.example.notice.entity.Attachments;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AttachmentsDto {

  private String path;
  private String originalName;
  private String systemName;
  private Long volume;

  @Builder
  public AttachmentsDto(String path, String originalName, String systemName, Long volume) {
    this.path = path;
    this.originalName = originalName;
    this.systemName = systemName;
    this.volume = volume;
  }

  public Attachments toEntity(AttachmentsDto attachmentsDto) {
    return Attachments.builder()
        .path(attachmentsDto.getPath())
        .originalName(attachmentsDto.getOriginalName())
        .systemName(attachmentsDto.getSystemName())
        .volume(attachmentsDto.getVolume())
        .build();
  }
}
