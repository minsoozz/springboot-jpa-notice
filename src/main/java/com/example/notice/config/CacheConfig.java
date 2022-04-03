package com.example.notice.config;

import static com.example.notice.model.dto.RedisCacheType.NOTICE;
import static com.example.notice.model.dto.RedisCacheType.VIEWS;
import static org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair.fromSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@RequiredArgsConstructor
public class CacheConfig {

  private final RedisConnectionFactory connectionFactory;

  @Bean
  public RedisCacheManager redisCacheManager() {

    return RedisCacheManager
        .RedisCacheManagerBuilder
        .fromConnectionFactory(connectionFactory)
        .cacheDefaults(defaultConfiguration())
        .withInitialCacheConfigurations(customConfigurationMap())
        .build();
  }

  private RedisCacheConfiguration defaultConfiguration() {
    return RedisCacheConfiguration.defaultCacheConfig()
        .serializeKeysWith(fromSerializer(new StringRedisSerializer()))
        .serializeValuesWith(fromSerializer(new GenericJackson2JsonRedisSerializer()))
        .entryTtl(Duration.ofMinutes(1));
  }

  private Map<String, RedisCacheConfiguration> customConfigurationMap() {
    Map<String, RedisCacheConfiguration> customConfigurationMap = new HashMap<>();
    customConfigurationMap.put(NOTICE.getKey(), defaultConfiguration().entryTtl(NOTICE.getDuration()));
    customConfigurationMap.put(VIEWS.getKey(), defaultConfiguration().entryTtl(VIEWS.getDuration()));
    return customConfigurationMap;
  }
}
