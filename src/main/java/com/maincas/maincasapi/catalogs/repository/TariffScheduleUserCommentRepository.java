package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.catalogs.model.TariffScheduleUserComment;

public interface TariffScheduleUserCommentRepository
    extends PagingAndSortingRepository<TariffScheduleUserComment, Long> {
  List<TariffScheduleUserComment> findByTariffScheduleId(Long tariffScheduleId);
}
