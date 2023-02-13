package com.maincas.maincasapi.operation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.operation.model.ReceiptUserComment;

public interface ReceiptUserCommentRepository extends JpaRepository<ReceiptUserComment, Long> {
  List<ReceiptUserComment> findByReceiptId(Long receiptId);
}
