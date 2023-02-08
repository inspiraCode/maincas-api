package com.maincas.maincasapi.operation.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.operation.model.ReceiptUserComment;

public interface ReceiptUserCommentRepository extends PagingAndSortingRepository<ReceiptUserComment, Long> {
  List<ReceiptUserComment> findByReceiptId(Long receiptId);
}
