package com.maincas.maincasapi.catalogs.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.maincas.maincasapi.catalogs.model.TariffSchedule;
import com.maincas.maincasapi.catalogs.repository.TariffScheduleRepository;
import com.maincas.maincasapi.service.AbstractMaincasServiceImpl;

@Service
public class TariffScheduleServiceImpl extends AbstractMaincasServiceImpl<TariffSchedule, TariffScheduleRepository> implements TariffScheduleService {

  @Override
  public TariffSchedule update(Long id, TariffSchedule tariffSchedule) {
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
  
}
