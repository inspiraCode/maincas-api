package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.catalogs.model.PartNumberVendor;

public interface PartNumberVendorRepository extends JpaRepository<PartNumberVendor, Long> {
  List<PartNumberVendor> findByPartNumberId(Long partNumberId);
}
