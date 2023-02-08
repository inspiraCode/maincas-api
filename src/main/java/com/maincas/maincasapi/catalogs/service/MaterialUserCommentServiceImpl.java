package com.maincas.maincasapi.catalogs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maincas.maincasapi.catalogs.model.MaterialUserComment;
import com.maincas.maincasapi.catalogs.repository.MaterialUserCommentRepository;
import com.maincas.maincasapi.service.AbstractUserCommentServiceImpl;

@Service
public class MaterialUserCommentServiceImpl extends
    AbstractUserCommentServiceImpl<MaterialUserComment, MaterialUserCommentRepository>
    implements MaterialUserCommentService {

  @Override
  public List<MaterialUserComment> fetchByParentId(Long id) {
    return repo.findByMaterialId(id);
  }

}
