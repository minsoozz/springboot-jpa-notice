package com.example.notice.repository;

import com.example.notice.model.response.AttachmentsResponseDto;
import java.util.List;

public interface AttachmentsRepositoryCustom {

  List<AttachmentsResponseDto> selectAttachmentsByNoticeId(Long noticeId);
}
