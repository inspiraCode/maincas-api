package com.maincas.maincasapi.catalogs.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.maincas.maincasapi.catalogs.model.Material;
import com.maincas.maincasapi.catalogs.repository.MaterialRepository;
import com.maincas.maincasapi.service.AbstractMaincasServiceImpl;

@Service
public class MaterialServiceImpl extends AbstractMaincasServiceImpl<Material, MaterialRepository>
    implements MaterialService {

  @Override
  public Material update(Long id, Material material) {
    String errorMessage = String.format("Unable to find {} by id {}", getType().toString(), id);
    Material dbMaterial = fetchById(id).orElseThrow(() -> new IllegalArgumentException(errorMessage));
    // material.getApprovedImpo()
    if (Objects.nonNull(material.getApprovedImpo()))
      dbMaterial.setApprovedImpo(material.getApprovedImpo());

    // material.getCompany();
    if (Objects.nonNull(material.getCompany()))
      dbMaterial.setCompany(material.getCompany());
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
}
