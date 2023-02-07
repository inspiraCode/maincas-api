package com.maincas.maincasapi.catalogs.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maincas.maincasapi.catalogs.model.Material;
import com.maincas.maincasapi.catalogs.repository.MaterialRepository;

@Service
public class MaterialServiceImpl implements MaterialService {

  @Autowired
  MaterialRepository repo;

  @Autowired
  private AuditReader auditReader;

  @Override
  public List<Material> fetchAllMaterials() {
    return StreamSupport.stream(repo.findAll().spliterator(), false).collect(Collectors.toList());
  }

  @Override
  public Material fetchById(Long id) {
    return repo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException(String.format("Unable to find material by id {}", id)));
  }

  @Override
  public Material updateMaterial(Long id, Material material) {
    Material dbMaterial = fetchById(id);
    // material.getApprovedImpo()
    if (Objects.nonNull(material.getApprovedImpo()))
      dbMaterial.setApprovedImpo(material.getApprovedImpo());

    // material.getBuyer();
    if (Objects.nonNull(material.getBuyer()))
      dbMaterial.setBuyer(material.getBuyer());
    // material.getCommercialDescription();
    if (Objects.nonNull(material.getCommercialDescription())
        && !"".equalsIgnoreCase(material.getCommercialDescription()))
      dbMaterial.setCommercialDescription(material.getCommercialDescription());
    // material.getLegalDescription();
    if (Objects.nonNull(material.getLegalDescription())
        && !"".equalsIgnoreCase(material.getLegalDescription()))
      dbMaterial.setLegalDescription(material.getLegalDescription());
    // material.getSedDescription();
    if (Objects.nonNull(material.getSedDescription())
        && !"".equalsIgnoreCase(material.getSedDescription()))
      dbMaterial.setSedDescription(material.getSedDescription());
    // material.getSedTariffSchedule();
    if (Objects.nonNull(material.getSedTariffSchedule()))
      dbMaterial.setSedTariffSchedule(material.getSedTariffSchedule());
    // material.getTariffSchedule();
    if (Objects.nonNull(material.getTariffSchedule()))
      dbMaterial.setTariffSchedule(material.getTariffSchedule());
    // material.getObservations()
    if (Objects.nonNull(material.getObservations()) && !"".equalsIgnoreCase(material.getObservations()))
      dbMaterial.setObservations(material.getObservations());

    return repo.save(dbMaterial);
  }

  @Override
  public Material createMaterial(Material material) {
    return repo.save(material);
  }

  @Override
  public void deleteMaterialById(Long id) {
    repo.deleteById(id);
  }

  @Override
  public List<?> getRevisions(Long id, boolean fetchChanges) {
    AuditQuery auditQuery = null;

    if (fetchChanges) {
      auditQuery = auditReader.createQuery()
          .forRevisionsOfEntityWithChanges(Material.class, true);
    } else {
      auditQuery = auditReader.createQuery()
          .forRevisionsOfEntity(Material.class, true);
    }
    auditQuery.add(AuditEntity.id().eq(id));
    return auditQuery.getResultList();
  }

}
