package com.example.notice.entity;

import java.time.LocalDate;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;

@MappedSuperclass
public abstract class BaseEntity {

  @CreatedDate
  private LocalDate createDate;

  private LocalDate deleteDate;
}
