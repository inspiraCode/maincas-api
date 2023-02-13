package com.maincas.maincasapi.catalogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.catalogs.model.TariffSchedule;

public interface TariffScheduleRepository extends JpaRepository<TariffSchedule, Long> {

}
