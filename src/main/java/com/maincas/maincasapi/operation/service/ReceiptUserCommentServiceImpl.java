package com.maincas.maincasapi.operation.service;

import java.util.List;

import com.maincas.maincasapi.operation.model.ReceiptUserComment;
import com.maincas.maincasapi.operation.repository.ReceiptUserCommentRepository;
import com.maincas.maincasapi.service.AbstractMaincasItemServiceImpl;

public class ReceiptUserCommentServiceImpl extends
    AbstractMaincasItemServiceImpl<ReceiptUserComment, ReceiptUserCommentRepository>
    implements ReceiptUserCommentService {

  @Override
  public List<ReceiptUserComment> fetchByParentId(Long id) {
    return repo.findByReceiptId(id);
  }

}
