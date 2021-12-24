package com.example.notice.repository.impl;

import com.example.notice.model.response.NoticeResponseDto;
import com.example.notice.model.response.QNoticeResponseDto;
import com.example.notice.repository.NoticeRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.example.notice.entity.QNotice.notice;

@RequiredArgsConstructor
public class NoticeRepositoryCustomImpl implements NoticeRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<NoticeResponseDto> selectNotice(Long id) {
        NoticeResponseDto noticeResponseDto = jpaQueryFactory.select(
                        new QNoticeResponseDto(notice.createdDate, notice.id, notice.title, notice.content, notice.views,
                                notice.writer))
                .from(notice)
                .where(notice.id.eq(id))
                .fetchOne();
        return Optional.ofNullable(noticeResponseDto);
    }
}
