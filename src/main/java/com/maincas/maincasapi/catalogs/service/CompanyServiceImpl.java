package com.maincas.maincasapi.catalogs.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maincas.maincasapi.catalogs.model.Company;
import com.maincas.maincasapi.catalogs.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

  @Autowired
  CompanyRepository repo;

  @Autowired
  private AuditReader auditReader;

  @Override
  public List<Company> fetchAllCompanies() {
    return StreamSupport.stream(repo.findAll().spliterator(), false).collect(Collectors.toList());
  }

  @Override
  public Company fetchById(Long id) {
    return repo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException(String.format("Unable to find company by id {}", id)));
  }

  @Override
  public Company updateCompany(Long id, Company company) {
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

  @Override
  public Company createCompany(Company company) {
    return repo.save(company);
  }

  @Override
  public void deleteCompanyById(Long id) {
    repo.deleteById(id);
  }

  @Override
  public List<?> getRevisions(Long id, boolean fetchChanges) {
    AuditQuery auditQuery = null;

    if (fetchChanges) {
      auditQuery = auditReader.createQuery()
          .forRevisionsOfEntityWithChanges(Company.class, true);
    } else {
      auditQuery = auditReader.createQuery()
          .forRevisionsOfEntity(Company.class, true);
    }
    auditQuery.add(AuditEntity.id().eq(id));
    return auditQuery.getResultList();
  }

  public List<Company> fetchByRole(String role){
    return repo.findByRolesContainingIgnoreCase(role);
  }

}
