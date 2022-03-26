package com.example.notice.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class NoticeUpdateRequestDto implements Serializable {


  private static final long serialVersionUID = 4255536558575792623L;

  private String title;
  private String content;
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime startDate;
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime endDate;
  private List<MultipartFile> attachments = new ArrayList<>();
  private List<Long> tobeDeletedAttachments = new ArrayList<>();

}
