package com.example.notice.model.dto;

import java.time.Duration;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RedisCacheType {

  NOTICE("notice", Duration.ofSeconds(5L)),
  VIEWS("views", Duration.ofSeconds(1L));

  public final String key;
  public final Duration duration;
}
