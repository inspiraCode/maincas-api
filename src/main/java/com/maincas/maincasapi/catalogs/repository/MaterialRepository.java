package com.maincas.maincasapi.catalogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.catalogs.model.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {

}
