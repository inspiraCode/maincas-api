package com.maincas.maincasapi.operation.service;

import java.util.List;

import com.maincas.maincasapi.operation.model.ReceiptItem;

public interface ReceiptItemService {
  List<ReceiptItem> fetchReceiptItemsByReceiptId(Long id);

  ReceiptItem fetchById(Long id);

  ReceiptItem updateReceiptItem(Long id, ReceiptItem receiptItem);

  ReceiptItem createReceiptItem(ReceiptItem receiptItem);

  void deleteReceiptItemById(Long id);

  List<?> getRevisions(Long id, boolean fetchChanges);
}
