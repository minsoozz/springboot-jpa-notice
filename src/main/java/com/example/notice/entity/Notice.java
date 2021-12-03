package com.example.notice.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  //TODO:: nullable & columnDefault 설정
  @Column(nullable = false)
  private String content;

  @Column(nullable = false)
  private String writer;

  @Column(nullable = false)
  private int views;

  @Column(nullable = false)
  private LocalDateTime startDate;

  @Column(nullable = false)
  private LocalDateTime endDate;

  //TODO:: CascadeType 전략 수정
  @OneToMany(mappedBy = "notice", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Attachments> attachmentsList = new ArrayList<>();

  @Builder
  public Notice(String title, String content, String writer, int views, LocalDateTime startDate,
      LocalDateTime endDate) {
    this.title = title;
    this.content = content;
    this.writer = writer;
    this.views = views;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public void addAttachments(Attachments attachments) {
    this.attachmentsList.add(attachments);
    attachments.addNotice(this);
  }
}
