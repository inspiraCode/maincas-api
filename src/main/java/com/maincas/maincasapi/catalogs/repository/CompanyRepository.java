package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.catalogs.model.Company;

public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {
  public List<Company> findByRolesContainingIgnoreCase(String role);
}
