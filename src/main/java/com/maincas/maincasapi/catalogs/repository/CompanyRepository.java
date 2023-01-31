package com.maincas.maincasapi.catalogs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.catalogs.model.Company;

public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {

}
