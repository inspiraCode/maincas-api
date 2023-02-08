package com.maincas.maincasapi.catalogs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maincas.maincasapi.catalogs.model.CompanyUserComment;
import com.maincas.maincasapi.catalogs.repository.CompanyUserCommentRepository;
import com.maincas.maincasapi.service.AbstractMaincasItemServiceImpl;

@Service
public class CompanyUserCommentServiceImpl extends
    AbstractMaincasItemServiceImpl<CompanyUserComment, CompanyUserCommentRepository>
    implements CompanyUserCommentService {
      
  @Override
  public List<CompanyUserComment> fetchByParentId(Long id) {
    return repo.findByCompanyId(id);
  }
}
