package com.maincas.maincasapi.operation.service;

import java.util.List;

import com.maincas.maincasapi.operation.model.Receipt;

public interface ReceiptService {
  List<Receipt> fetchAllReceipts();

  Receipt fetchById(Long id);

  Receipt updateReceipt(Long id, Receipt receipt);

  Receipt createReceipt(Receipt receipt);

  void deleteReceiptById(Long id);

  List<?> getRevisions(Long id, boolean fetchChanges);
}
