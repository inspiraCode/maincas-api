package com.maincas.maincasapi.catalogs.service;

import java.util.List;

import com.maincas.maincasapi.catalogs.model.Company;

public interface CompanyService {
  List<Company> fetchAllCompanies();

  Company fetchById(Long id);

  Company updateCompany(Long id, Company company);

  Company createCompany(Company company);

  void deleteCompanyById(Long id);

  List<?> getRevisions(Long id, boolean fetchChanges);
}
