package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.catalogs.model.CompanyUserComment;

public interface CompanyUserCommentRepository extends PagingAndSortingRepository<CompanyUserComment, Long> {
  List<CompanyUserComment> findByCompanyId(Long companyId);

}
