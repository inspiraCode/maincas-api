package com.maincas.maincasapi.catalogs.service;

import java.util.List;

import com.maincas.maincasapi.catalogs.model.Company;
import com.maincas.maincasapi.service.IMaincasService;

public interface CompanyService extends IMaincasService<Company> {
  List<Company> fetchByRole(String role);
}
