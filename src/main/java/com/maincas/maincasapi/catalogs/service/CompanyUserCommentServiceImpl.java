package com.maincas.maincasapi.catalogs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maincas.maincasapi.catalogs.model.CompanyUserComment;
import com.maincas.maincasapi.catalogs.repository.CompanyUserCommentRepository;
import com.maincas.maincasapi.service.AbstractUserCommentServiceImpl;

@Service
public class CompanyUserCommentServiceImpl extends
    AbstractUserCommentServiceImpl<CompanyUserComment, CompanyUserCommentRepository>
    implements CompanyUserCommentService {

  @Override
  public List<CompanyUserComment> fetchByParentId(Long id) {
    return repo.findByCompanyId(id);
  }
}
