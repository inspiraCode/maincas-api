package com.maincas.maincasapi.operation.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maincas.maincasapi.operation.model.Receipt;
import com.maincas.maincasapi.operation.repository.ReceiptRepository;

@Service
public class ReceiptServiceImpl implements ReceiptService {

  @Autowired
  ReceiptRepository repo;

  @Autowired
  private AuditReader auditReader;

  @Override
  public Receipt createReceipt(Receipt receipt) {
    return repo.save(receipt);
  }

  @Override
  public void deleteReceiptById(Long id) {
    repo.deleteById(id);
  }

  @Override
  public List<Receipt> fetchAllReceipts() {
    return StreamSupport.stream(repo.findAll().spliterator(), false).collect(Collectors.toList());
  }

  @Override
  public Receipt fetchById(Long id) {
    return repo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException(String.format("Unable to find receipt by id {}", id)));
  }

  @Override
  public List<?> getRevisions(Long id, boolean fetchChanges) {
    AuditQuery auditQuery = null;

    if (fetchChanges) {
      auditQuery = auditReader.createQuery()
          .forRevisionsOfEntityWithChanges(Receipt.class, true);
    } else {
      auditQuery = auditReader.createQuery()
          .forRevisionsOfEntity(Receipt.class, true);
    }
    auditQuery.add(AuditEntity.id().eq(id));
    return auditQuery.getResultList();
  }

  @Override
  public Receipt updateReceipt(Long id, Receipt receipt) {
    receipt.setId(id);
    return repo.save(receipt);
  }

}
