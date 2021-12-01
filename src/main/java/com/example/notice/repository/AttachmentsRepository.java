package com.example.notice.repository;

import com.example.notice.entity.Attachments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentsRepository extends JpaRepository<Attachments, Long> {

}
