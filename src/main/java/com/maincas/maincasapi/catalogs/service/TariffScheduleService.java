package com.maincas.maincasapi.catalogs.service;

import java.util.List;

import com.maincas.maincasapi.catalogs.model.TariffSchedule;

public interface TariffScheduleService {
  List<TariffSchedule> fetchAllTariffSchedules();

  TariffSchedule fetchById(Long id);

  TariffSchedule updateTariffSchedule(Long id, TariffSchedule tariffSchedule);

  TariffSchedule createTariffSchedule(TariffSchedule tariffSchedule);

  void deleteTariffScheduleById(Long id);

  List<?> getRevisions(Long id, boolean fetchChanges);
}
