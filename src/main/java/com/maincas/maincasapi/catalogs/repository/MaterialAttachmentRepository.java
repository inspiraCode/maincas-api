package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.catalogs.model.MaterialAttachment;

public interface MaterialAttachmentRepository extends PagingAndSortingRepository<MaterialAttachment, Long> {
  List<MaterialAttachment> findByMaterialId(Long materialId);
}
