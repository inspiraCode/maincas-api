package com.maincas.maincasapi.catalogs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maincas.maincasapi.catalogs.model.PartNumberUserComment;
import com.maincas.maincasapi.catalogs.repository.PartNumberUserCommentRepository;
import com.maincas.maincasapi.service.AbstractMaincasItemServiceImpl;

@Service
public class PartNumberUserCommentServiceImpl extends
    AbstractMaincasItemServiceImpl<PartNumberUserComment, PartNumberUserCommentRepository>
    implements PartNumberUserCommentService {

  @Override
  public List<PartNumberUserComment> fetchByParentId(Long id) {
    return repo.findByPartNumberId(id);
  }

}
