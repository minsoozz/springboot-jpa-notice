package com.example.notice.repository.impl;

import com.example.notice.model.response.NoticeResponseDto;
import com.example.notice.model.response.QNoticeResponseDto;
import com.example.notice.repository.NoticeRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.example.notice.entity.QNotice.notice;

@RequiredArgsConstructor
public class NoticeRepositoryCustomImpl implements NoticeRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public NoticeResponseDto selectNotice(Long id) {
        return jpaQueryFactory.select(
                        new QNoticeResponseDto(notice.title, notice.content, notice.createdDate, notice.views, notice.writer))
                .from(notice)
                .where(notice.id.eq(id))
                .fetchOne();
    }
}