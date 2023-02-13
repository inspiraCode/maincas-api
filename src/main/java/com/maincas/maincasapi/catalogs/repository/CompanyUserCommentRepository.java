package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.catalogs.model.CompanyUserComment;

public interface CompanyUserCommentRepository extends JpaRepository<CompanyUserComment, Long> {
  List<CompanyUserComment> findByCompanyId(Long companyId);

}
