package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.catalogs.model.MaterialAttachment;

public interface MaterialAttachmentRepository extends JpaRepository<MaterialAttachment, Long> {
  List<MaterialAttachment> findByMaterialId(Long materialId);
}
