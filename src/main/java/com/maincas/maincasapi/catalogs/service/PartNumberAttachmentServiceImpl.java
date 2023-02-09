package com.maincas.maincasapi.catalogs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maincas.maincasapi.catalogs.model.PartNumberAttachment;
import com.maincas.maincasapi.catalogs.repository.PartNumberAttachmentRepository;
import com.maincas.maincasapi.service.AbstractAttachmentServiceImpl;

@Service
public class PartNumberAttachmentServiceImpl
    extends AbstractAttachmentServiceImpl<PartNumberAttachment, PartNumberAttachmentRepository>
    implements PartNumberAttachmentService {

  @Override
  public List<PartNumberAttachment> fetchByParentId(Long id) {
    return repo.findByPartNumberId(id);
  }
}
