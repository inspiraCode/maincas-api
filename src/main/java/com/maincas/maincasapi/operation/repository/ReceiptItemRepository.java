package com.maincas.maincasapi.operation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.operation.model.ReceiptItem;

public interface ReceiptItemRepository extends JpaRepository<ReceiptItem, Long> {
  List<ReceiptItem> findByReceiptId(Long receiptId);
}
