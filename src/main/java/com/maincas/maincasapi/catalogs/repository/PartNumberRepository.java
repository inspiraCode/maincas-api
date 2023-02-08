package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.catalogs.model.PartNumber;

public interface PartNumberRepository extends PagingAndSortingRepository<PartNumber, Long> {
  List<PartNumber> findByBuyerId(Long buyerId);

  List<PartNumber> findByMaterialId(Long materialId);
}
