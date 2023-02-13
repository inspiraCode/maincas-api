package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.catalogs.model.PartNumber;

public interface PartNumberRepository extends JpaRepository<PartNumber, Long> {
  List<PartNumber> findByBuyerId(Long buyerId);

  List<PartNumber> findByMaterialId(Long materialId);
}
