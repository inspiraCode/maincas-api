package com.maincas.maincasapi.catalogs.service;

import java.util.List;

import com.maincas.maincasapi.catalogs.model.Material;

public interface MaterialService {
  List<Material> fetchAllMaterials();

  Material fetchById(Long id);

  Material updateMaterial(Long id, Material material);

  Material createMaterial(Material material);

  void deleteMaterialById(Long id);

  List<?> getRevisions(Long id, boolean fetchChanges);
}
