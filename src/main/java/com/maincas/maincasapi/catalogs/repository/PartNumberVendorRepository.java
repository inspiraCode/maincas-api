package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.catalogs.model.PartNumberVendor;

public interface PartNumberVendorRepository extends PagingAndSortingRepository<PartNumberVendor, Long> {
  List<PartNumberVendor> findByPartNumberId(Long partNumberId);
}
