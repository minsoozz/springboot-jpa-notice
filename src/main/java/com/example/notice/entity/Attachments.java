package com.example.notice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Attachments extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String path;

  @Column(nullable = false)
  private String originalName;

  @Column(nullable = false)
  private String systemName;

  @Column(nullable = false)
  private Long volume;

  @ManyToOne
  private Notice notice;

  @Builder
  public Attachments(String path, String originalName, String systemName,
      Long volume) {
    this.path = path;
    this.originalName = originalName;
    this.systemName = systemName;
    this.volume = volume;
  }

  public void addNotice(Notice notice) {
    this.notice = notice;
  }
}
