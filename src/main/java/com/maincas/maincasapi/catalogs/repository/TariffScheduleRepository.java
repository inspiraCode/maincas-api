package com.maincas.maincasapi.catalogs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.catalogs.model.TariffSchedule;

public interface TariffScheduleRepository extends PagingAndSortingRepository<TariffSchedule, Long> {
  
}
