package com.example.notice.repository;

import com.example.notice.entity.RedisEntity;
import org.springframework.data.repository.CrudRepository;

public interface RedisRepository extends CrudRepository<RedisEntity, Long> {

}
