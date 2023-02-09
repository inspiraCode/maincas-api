package com.maincas.maincasapi.operation.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.operation.model.ReceiptAttachment;

public interface ReceiptAttachmentRepository extends PagingAndSortingRepository<ReceiptAttachment, Long> {
  List<ReceiptAttachment> findByReceiptId(Long receiptId);
}
