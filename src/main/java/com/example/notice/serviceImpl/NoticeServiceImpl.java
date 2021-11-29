package com.example.notice.serviceImpl;

import com.example.notice.entity.Notice;
import com.example.notice.service.NoticeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

  @Override
  public void insertNotice() {

  }

  @Override
  public Notice selectNotice(Long id) {
    return null;
  }

  @Override
  public void updateNotice() {

  }

  @Override
  public void deleteNotice() {

  }
}
