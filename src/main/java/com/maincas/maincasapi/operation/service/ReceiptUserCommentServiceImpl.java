package com.maincas.maincasapi.operation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maincas.maincasapi.operation.model.ReceiptUserComment;
import com.maincas.maincasapi.operation.repository.ReceiptUserCommentRepository;
import com.maincas.maincasapi.service.AbstractUserCommentServiceImpl;

@Service
public class ReceiptUserCommentServiceImpl extends
    AbstractUserCommentServiceImpl<ReceiptUserComment, ReceiptUserCommentRepository>
    implements ReceiptUserCommentService {

  @Override
  public List<ReceiptUserComment> fetchByParentId(Long id) {
    return repo.findByReceiptId(id);
  }

}
