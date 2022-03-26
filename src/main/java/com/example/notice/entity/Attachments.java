package com.example.notice.entity;

import com.sun.istack.NotNull;
 import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Attachments extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String path;

  @NotNull
  private String originalName;

  @NotNull
  private String systemName;

  @NotNull
  private Long volume;

  @ManyToOne(cascade = CascadeType.ALL)
  private Notice notice;

  @Builder
  public Attachments(String path, String originalName, String systemName, Long volume) {
    this.path = path;
    this.originalName = originalName;
    this.systemName = systemName;
    this.volume = volume;
  }

  public void updateNotice(Notice notice) {
    this.notice = notice;
  }
}
