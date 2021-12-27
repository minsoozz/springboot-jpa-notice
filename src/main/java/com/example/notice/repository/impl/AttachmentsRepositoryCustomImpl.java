package com.example.notice.repository.impl;

import static com.example.notice.entity.QAttachments.attachments;
import static com.example.notice.entity.QNotice.notice;

import com.example.notice.model.response.AttachmentsResponseDto;
import com.example.notice.model.response.QAttachmentsResponseDto;
import com.example.notice.repository.AttachmentsRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AttachmentsRepositoryCustomImpl implements AttachmentsRepositoryCustom {

  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public List<AttachmentsResponseDto> selectAttachmentsByNoticeId(Long noticeId) {
    return jpaQueryFactory.select(
            new QAttachmentsResponseDto(attachments.createdDate, attachments.id, attachments.originalName))
        .from(attachments)
        .leftJoin(attachments.notice, notice)
        .where(notice.id.eq(noticeId))
        .fetch();
  }

  @Override
  public List<Long> selectAttachmentsIdListByNoticeId(Long id) {
    return jpaQueryFactory
        .select(attachments.id)
        .from(attachments)
        .leftJoin(attachments.notice, notice)
        .where(notice.id.eq(id))
        .fetch();

  }
}
