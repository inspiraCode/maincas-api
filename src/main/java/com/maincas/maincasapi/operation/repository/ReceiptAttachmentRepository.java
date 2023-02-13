package com.maincas.maincasapi.operation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.operation.model.ReceiptAttachment;

public interface ReceiptAttachmentRepository extends JpaRepository<ReceiptAttachment, Long> {
  List<ReceiptAttachment> findByReceiptId(Long receiptId);
}
