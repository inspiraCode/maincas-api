package com.maincas.maincasapi.operation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maincas.maincasapi.operation.model.ReceiptAttachment;
import com.maincas.maincasapi.operation.repository.ReceiptAttachmentRepository;
import com.maincas.maincasapi.service.AbstractAttachmentServiceImpl;

@Service
public class ReceiptAttachmentServiceImpl
    extends AbstractAttachmentServiceImpl<ReceiptAttachment, ReceiptAttachmentRepository>
    implements ReceiptAttachmentService {

  @Override
  public List<ReceiptAttachment> fetchByParentId(Long id) {
    return repo.findByReceiptId(id);
  }
}
