package com.example.notice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import com.example.notice.entity.Notice;
import com.example.notice.model.request.NoticeInsertRequestDto;
import com.example.notice.repository.AttachmentsRepository;
import com.example.notice.repository.NoticeRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class NoticeServiceTest {

  private NoticeService noticeService;

  @Mock
  private NoticeRepository noticeRepository;

  @Mock
  private AttachmentsRepository attachmentsRepository;

  @Mock
  private AttachmentsService attachmentsService;

  @BeforeEach
  void setUp() {
    noticeService = new NoticeService(noticeRepository, attachmentsRepository, attachmentsService);
  }

  @Test
  @DisplayName("게시글 조회 테스트")
  void selectNoticeTest() {

  }
}