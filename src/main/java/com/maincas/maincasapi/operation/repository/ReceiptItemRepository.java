package com.maincas.maincasapi.operation.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.operation.model.ReceiptItem;

public interface ReceiptItemRepository extends PagingAndSortingRepository<ReceiptItem, Long> {
  List<ReceiptItem> findByReceiptId(Long receiptId);
}
