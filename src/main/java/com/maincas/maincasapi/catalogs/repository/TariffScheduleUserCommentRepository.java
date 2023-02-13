package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.catalogs.model.TariffScheduleUserComment;

public interface TariffScheduleUserCommentRepository
    extends JpaRepository<TariffScheduleUserComment, Long> {
  List<TariffScheduleUserComment> findByTariffScheduleId(Long tariffScheduleId);
}
