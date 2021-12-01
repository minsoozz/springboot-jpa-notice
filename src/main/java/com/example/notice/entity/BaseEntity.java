package com.example.notice.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;

@MappedSuperclass
public abstract class BaseEntity {

  @CreatedDate
  private LocalDate createDate;
}
