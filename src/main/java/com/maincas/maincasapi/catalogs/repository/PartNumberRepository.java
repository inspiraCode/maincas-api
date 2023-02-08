package com.maincas.maincasapi.catalogs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.catalogs.model.PartNumber;

public interface PartNumberRepository extends PagingAndSortingRepository<PartNumber, Long> {
  
}
