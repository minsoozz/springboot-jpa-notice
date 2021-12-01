package com.example.notice.entity;

import java.time.LocalDate;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE notice SET delete_date = NOW() WHERE id = ?")
public class Notice extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String content;

  @Column(nullable = false)
  private String writer;

  @Column(nullable = false)
  private LocalDate startDate;

  @Column(nullable = false)
  private LocalDate endDate;

  @OneToMany(mappedBy = "notice", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Attachments> attachmentsList = new ArrayList<>();

  @Builder
  public Notice(Long id, String title, String content, String writer, LocalDate startDate,
      LocalDate endDate) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.writer = writer;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public void addAttachments(Attachments attachments) {
    this.attachmentsList.add(attachments);
    attachments.addNotice(this);
  }
}
