package com.maincas.maincasapi.operation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maincas.maincasapi.operation.model.ReceiptItem;
import com.maincas.maincasapi.operation.repository.ReceiptItemRepository;
import com.maincas.maincasapi.service.AbstractMaincasItemServiceImpl;

@Service
public class ReceiptItemServiceImpl extends AbstractMaincasItemServiceImpl<ReceiptItem, ReceiptItemRepository> implements ReceiptItemService {

  @Override
  public List<ReceiptItem> fetchByParentId(Long id) {
    return repo.findByReceiptId(id);
  }

}
