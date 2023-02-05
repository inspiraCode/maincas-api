package com.maincas.maincasapi.catalogs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.catalogs.model.Material;

public interface MaterialRepository extends PagingAndSortingRepository<Material, Long> {
  
}
