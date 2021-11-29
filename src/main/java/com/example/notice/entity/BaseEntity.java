package com.example.notice.entity;

import java.time.LocalDateTime;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

  private LocalDateTime createDate;
}
