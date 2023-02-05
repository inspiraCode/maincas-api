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

import com.maincas.maincasapi.catalogs.model.TariffSchedule;
import com.maincas.maincasapi.catalogs.repository.TariffScheduleRepository;

@Service
public class TariffScheduleImpl implements TariffScheduleService {

  @Autowired
  private TariffScheduleRepository repo;

  @Autowired
  private AuditReader auditReader;

  public List<TariffSchedule> fetchAllTariffSchedules() {
    return StreamSupport.stream(repo.findAll().spliterator(), false).collect(Collectors.toList());
  }

  public TariffSchedule fetchById(Long id) {
    return repo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException(String.format("Unable to find tariff schedule by id {}", id)));
  }

  public TariffSchedule updateTariffSchedule(Long id, TariffSchedule tariffSchedule) {
    TariffSchedule dbTs = fetchById(id);

    if (Objects.nonNull(tariffSchedule.getBaseDescription())
        && !"".equalsIgnoreCase(tariffSchedule.getBaseDescription()))
      dbTs.setBaseDescription(tariffSchedule.getBaseDescription());

    // tariffSchedule.getCode()
    if (Objects.nonNull(tariffSchedule.getCode()) && !"".equalsIgnoreCase(tariffSchedule.getCode()))
      dbTs.setCode(tariffSchedule.getCode());

    // tariffSchedule.getDocumentDescription()
    if (Objects.nonNull(tariffSchedule.getDocumentDescription())
        && !"".equalsIgnoreCase(tariffSchedule.getDocumentDescription()))
      dbTs.setDocumentDescription(tariffSchedule.getDocumentDescription());

    // tariffSchedule.getObservations()
    if (Objects.nonNull(tariffSchedule.getObservations()) && !"".equalsIgnoreCase(tariffSchedule.getObservations()))
      dbTs.setObservations(tariffSchedule.getObservations());

    // tariffSchedule.getUst()
    if (Objects.nonNull(tariffSchedule.getUst()) && !"".equalsIgnoreCase(tariffSchedule.getUst()))
      dbTs.setUst(tariffSchedule.getUst());

    return repo.save(dbTs);
  }

  public TariffSchedule createTariffSchedule(TariffSchedule tariffSchedule) {
    return repo.save(tariffSchedule);
  }

  public void deleteTariffScheduleById(Long id) {
    repo.deleteById(id);
  }

  public List<?> getRevisions(Long id, boolean fetchChanges) {
    AuditQuery auditQuery = null;

    if (fetchChanges) {
      auditQuery = auditReader.createQuery()
          .forRevisionsOfEntityWithChanges(TariffSchedule.class, true);
    } else {
      auditQuery = auditReader.createQuery()
          .forRevisionsOfEntity(TariffSchedule.class, true);
    }
    auditQuery.add(AuditEntity.id().eq(id));
    return auditQuery.getResultList();
  }
}
