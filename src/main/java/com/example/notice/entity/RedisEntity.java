package com.example.notice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("userId")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RedisEntity {

  @Id
  private Long userId;
  private Long noticeId;
}
