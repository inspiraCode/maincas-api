package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.catalogs.model.PartNumberAttachment;

public interface PartNumberAttachmentRepository extends JpaRepository<PartNumberAttachment, Long> {
  List<PartNumberAttachment> findByPartNumberId(Long partNumberId);
}
