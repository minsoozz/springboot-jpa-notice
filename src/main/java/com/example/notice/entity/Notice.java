package com.example.notice.entity;

import com.sun.istack.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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

  @NotNull
  private String title;

  @NotNull
  private String content;

  @NotNull
  private String writer;

  @NotNull
  private int views;

  @NotNull
  private LocalDateTime startDate;

  @NotNull
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
    attachments.updateNotice(this);
  }

  public void deleteAttachments(Attachments attachments) {
    this.attachmentsList.remove(attachments);
    attachments.updateNotice(null);
  }

  public void updateTitleAndContent(String title, String content) {
    this.title = title;
    this.content = content;
  }
}
