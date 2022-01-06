package com.example.notice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.example.notice.model.response.AttachmentsResponseDto;
import com.example.notice.model.response.NoticeResponseDto;
import com.example.notice.repository.AttachmentsRepository;
import com.example.notice.repository.NoticeRepository;
import java.util.Arrays;
import java.util.Optional;
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
    noticeResponseDto.setTitle("테스트제목");

    AttachmentsResponseDto attachmentsResponseDto = new AttachmentsResponseDto();
    attachmentsResponseDto.setOriginalName("테스트첨부파일");

    noticeResponseDto.setAttachmentsList(Arrays.asList(attachmentsResponseDto));

    // when
    when(noticeRepository.selectNotice(1L)).thenReturn(Optional.of(noticeResponseDto));
    NoticeResponseDto resultDto = noticeService.selectNotice(1L);

    // then
    assertThat(resultDto.getTitle()).isEqualTo(noticeResponseDto.getTitle());
    assertThat(resultDto.getAttachmentsList().get(0).getOriginalName())
        .isEqualTo(noticeResponseDto.getAttachmentsList().get(0).getOriginalName());

  }
}