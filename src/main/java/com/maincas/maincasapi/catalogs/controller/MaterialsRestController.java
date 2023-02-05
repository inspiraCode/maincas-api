package com.maincas.maincasapi.catalogs.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maincas.maincasapi.catalogs.model.Material;
import com.maincas.maincasapi.catalogs.service.MaterialService;

@RestController
@RequestMapping(path = "/api/material", produces = MediaType.APPLICATION_JSON_VALUE)
// TODO: Configure for production
@CrossOrigin(origins = "*")
public class MaterialsRestController {
  @Autowired
  private MaterialService service;

  @GetMapping(path = "/list")
  public List<Material> MaterialList() {
    return service.fetchAllMaterials();
  }

  @PostMapping("/create")
  public Material create(@RequestBody Material material) {
    return service.createMaterial(material);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getMaterialById(@PathVariable Long id) {
    return ResponseEntity.ok(service.fetchById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateMaterial(@PathVariable Long id, @RequestBody Material material) {
    return ResponseEntity.ok(service.updateMaterial(id, material));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteMaterial(@PathVariable Long id) {
    Map<String, Boolean> map = new LinkedHashMap<>();
    service.deleteMaterialById(id);
    map.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(map);
  }

  @GetMapping("/{id}/revisions")
  @SuppressWarnings("rawtypes")
  public ResponseEntity<?> getRevisions(@PathVariable(name = "id") String materialId,
      @RequestParam(value = "fetchChanges", required = false) boolean fetchChanges) {

    List results = service.getRevisions(Long.valueOf(materialId), fetchChanges);
    return ResponseEntity.ok(results);
  }
}
