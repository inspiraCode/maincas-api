package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.catalogs.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
  List<Company> findByRolesContainingIgnoreCase(String role);
}
