package com.maincas.maincasapi.catalogs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maincas.maincasapi.catalogs.model.CompanyAttachment;
import com.maincas.maincasapi.catalogs.repository.CompanyAttachmentRepository;
import com.maincas.maincasapi.service.AbstractAttachmentServiceImpl;

@Service
public class CompanyAttachmentServiceImpl
    extends AbstractAttachmentServiceImpl<CompanyAttachment, CompanyAttachmentRepository>
    implements CompanyAttachmentService {

  @Override
  public List<CompanyAttachment> fetchByParentId(Long id) {
    return repo.findByCompanyId(id);
  }
}
