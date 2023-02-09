package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.catalogs.model.CompanyAttachment;

public interface CompanyAttachmentRepository extends PagingAndSortingRepository<CompanyAttachment, Long> {
  List<CompanyAttachment> findByCompanyId(Long companyId);
}
