package com.example.notice.service;

import static org.mockito.Mockito.when;

import com.example.notice.model.response.NoticeResponseDto;
import com.example.notice.repository.AttachmentsRepository;
import com.example.notice.repository.NoticeRepository;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NoticeServiceTest {

  @Mock
  private NoticeRepository noticeRepository;

  @Mock
  AttachmentsRepository attachmentsRepository;

  @InjectMocks
  private NoticeService noticeService;

  @Test
  @DisplayName("게시글 조회 테스트")
  void selectNoticeTest() {
    // given
    NoticeResponseDto noticeResponseDto = new NoticeResponseDto();
    noticeResponseDto.setTitle("테스트");

    // when
    when(noticeRepository.selectNotice(1L)).thenReturn(Optional.of(noticeResponseDto));
    String title = noticeService.selectNotice(1L).getTitle();

    // then
    Assertions.assertThat(title).isEqualTo(noticeResponseDto.getTitle());


  }
}