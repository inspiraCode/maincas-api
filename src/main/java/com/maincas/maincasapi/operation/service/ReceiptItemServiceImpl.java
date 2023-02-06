package com.maincas.maincasapi.operation.service;

import java.util.List;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maincas.maincasapi.operation.model.ReceiptItem;
import com.maincas.maincasapi.operation.repository.ReceiptItemRepository;

@Service
public class ReceiptItemServiceImpl implements ReceiptItemService {

  @Autowired
  ReceiptItemRepository repo;

  @Autowired
  private AuditReader auditReader;

  @Override
  public ReceiptItem createReceiptItem(ReceiptItem receiptItem) {
    return repo.save(receiptItem);
  }

  @Override
  public void deleteReceiptItemById(Long id) {
    repo.deleteById(id);
  }

  @Override
  public List<ReceiptItem> fetchReceiptItemsByReceiptId(Long id) {
    return repo.findByReceiptId(id);
  }

  @Override
  public ReceiptItem fetchById(Long id) {
    return repo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException(String.format("Unable to find receipt item by id {}", id)));
  }

  @Override
  public List<?> getRevisions(Long id, boolean fetchChanges) {
    AuditQuery auditQuery = null;

    if (fetchChanges) {
      auditQuery = auditReader.createQuery()
          .forRevisionsOfEntityWithChanges(ReceiptItem.class, true);
    } else {
      auditQuery = auditReader.createQuery()
          .forRevisionsOfEntity(ReceiptItem.class, true);
    }
    auditQuery.add(AuditEntity.id().eq(id));
    return auditQuery.getResultList();
  }

  @Override
  public ReceiptItem updateReceiptItem(Long id, ReceiptItem receiptItem) {
    ReceiptItem dbReceiptItem = this.fetchById(id);
    receiptItem.setId(id);
    receiptItem.setReceipt(dbReceiptItem.getReceipt());
    return repo.save(receiptItem);
  }

}
