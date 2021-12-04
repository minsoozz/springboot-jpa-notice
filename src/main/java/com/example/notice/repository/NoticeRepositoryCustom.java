package com.example.notice.repository;

import com.example.notice.model.response.NoticeResponseDto;

public interface NoticeRepositoryCustom {

    NoticeResponseDto selectNotice(Long id);
}
