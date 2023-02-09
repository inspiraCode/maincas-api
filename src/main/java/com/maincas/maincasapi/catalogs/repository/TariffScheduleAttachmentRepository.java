package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.catalogs.model.TariffScheduleAttachment;

public interface TariffScheduleAttachmentRepository extends PagingAndSortingRepository<TariffScheduleAttachment, Long> {
  List<TariffScheduleAttachment> findByTariffScheduleId(Long tariffScheduleId);
}
