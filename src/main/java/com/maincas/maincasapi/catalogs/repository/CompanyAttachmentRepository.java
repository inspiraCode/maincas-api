package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.catalogs.model.CompanyAttachment;

public interface CompanyAttachmentRepository extends JpaRepository<CompanyAttachment, Long> {
  List<CompanyAttachment> findByCompanyId(Long companyId);
}
