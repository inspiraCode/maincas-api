package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.catalogs.model.PartNumberAttachment;

public interface PartNumberAttachmentRepository extends PagingAndSortingRepository<PartNumberAttachment, Long> {
  List<PartNumberAttachment> findByPartNumberId(Long partNumberId);
}
