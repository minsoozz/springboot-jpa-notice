package com.example.notice.repository;

import com.example.notice.model.response.NoticeResponseDto;

import java.util.Optional;

public interface NoticeRepositoryCustom {

  Optional<NoticeResponseDto> selectNotice(Long id);
}

