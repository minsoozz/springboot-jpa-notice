package com.example.notice.model.request;

import com.example.notice.entity.Notice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class NoticeRequestDto implements Serializable {

    private static final long serialVersionUID = -8366073361742189237L;

    private String title;
    private String content;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String writer;
    private List<MultipartFile> multipartFileList;

    public Notice toEntity(NoticeRequestDto noticeRequestDto) {
        return Notice
                .builder()
                .title(noticeRequestDto.getTitle())
                .content(noticeRequestDto.getContent())
                .startDate(noticeRequestDto.getStartDate())
                .endDate(noticeRequestDto.getEndDate())
                .writer(noticeRequestDto.getWriter())
                .build();
    }
}
