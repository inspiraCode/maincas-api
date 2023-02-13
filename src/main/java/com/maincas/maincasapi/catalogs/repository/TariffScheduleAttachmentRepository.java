package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.catalogs.model.TariffScheduleAttachment;

public interface TariffScheduleAttachmentRepository extends JpaRepository<TariffScheduleAttachment, Long> {
  List<TariffScheduleAttachment> findByTariffScheduleId(Long tariffScheduleId);
}
