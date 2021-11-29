package com.example.notice.service;

import com.example.notice.entity.Notice;

public interface NoticeService {

  void insertNotice();

  Notice selectNotice(Long id);

  void updateNotice();

  void deleteNotice();
}
