package com.maincas.maincasapi.catalogs.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.maincas.maincasapi.catalogs.model.Company;
import com.maincas.maincasapi.catalogs.repository.CompanyRepository;
import com.maincas.maincasapi.service.AbstractMaincasServiceImpl;

@Service
public class CompanyServiceImpl extends AbstractMaincasServiceImpl<Company, CompanyRepository> implements CompanyService {

  @Override
  public Company update(Long id, Company company) {
    Company dbCompany = repo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException(String.format("Unable to find company by id {}", id)));

    if (Objects.nonNull(company.getAddressCity()) && !"".equalsIgnoreCase(company.getAddressCity())) {
      dbCompany.setAddressCity(company.getAddressCity());
    }

    if (Objects.nonNull(company.getAddressCountry())
        && !"".equalsIgnoreCase(company.getAddressCountry())) {
      dbCompany.setAddressCountry(company.getAddressCountry());
    }

    if (Objects.nonNull(company.getAddressLineOne())
        && !"".equalsIgnoreCase(company.getAddressLineOne())) {
      dbCompany.setAddressLineOne(company.getAddressLineOne());
    }

    if (Objects.nonNull(company.getAddressLineTwo())
        && !"".equalsIgnoreCase(company.getAddressLineTwo())) {
      dbCompany.setAddressLineTwo(company.getAddressLineTwo());
    }

    if (Objects.nonNull(company.getAddressState())
        && !"".equalsIgnoreCase(company.getAddressState())) {
      dbCompany.setAddressState(company.getAddressState());
    }

    if (Objects.nonNull(company.getAddressZip())
        && !"".equalsIgnoreCase(company.getAddressZip())) {
      dbCompany.setAddressZip(company.getAddressZip());
    }

    if (Objects.nonNull(company.getAlias()) && !"".equalsIgnoreCase(company.getAlias())) {
      dbCompany.setAlias(company.getAlias());
    }

    if (Objects.nonNull(company.getName()) && !"".equalsIgnoreCase(company.getName())) {
      dbCompany.setName(company.getName());
    }

    if (Objects.nonNull(company.getRoles()) && !"".equalsIgnoreCase(company.getRoles())) {
      dbCompany.setRoles(company.getRoles());
    }

    if (Objects.nonNull(company.getBlock())) {
      dbCompany.setBlock(company.getBlock());
    }

    return repo.save(dbCompany);
  }

  public List<Company> fetchByRole(String role){
    return repo.findByRolesContainingIgnoreCase(role);
  }

}
