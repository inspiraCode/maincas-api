package com.maincas.maincasapi.catalogs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maincas.maincasapi.catalogs.model.MaterialAttachment;
import com.maincas.maincasapi.catalogs.repository.MaterialAttachmentRepository;
import com.maincas.maincasapi.service.AbstractAttachmentServiceImpl;

@Service
public class MaterialAttachmentServiceImpl
    extends AbstractAttachmentServiceImpl<MaterialAttachment, MaterialAttachmentRepository>
    implements MaterialAttachmentService {

  @Override
  public List<MaterialAttachment> fetchByParentId(Long id) {
    return repo.findByMaterialId(id);
  }
}
