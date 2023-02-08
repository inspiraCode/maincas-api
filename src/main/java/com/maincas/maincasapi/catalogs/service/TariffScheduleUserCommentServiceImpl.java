package com.maincas.maincasapi.catalogs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maincas.maincasapi.catalogs.model.TariffScheduleUserComment;
import com.maincas.maincasapi.catalogs.repository.TariffScheduleUserCommentRepository;
import com.maincas.maincasapi.service.AbstractMaincasItemServiceImpl;

@Service
public class TariffScheduleUserCommentServiceImpl extends
    AbstractMaincasItemServiceImpl<TariffScheduleUserComment, TariffScheduleUserCommentRepository>
    implements TariffScheduleUserCommentService {

  @Override
  public List<TariffScheduleUserComment> fetchByParentId(Long id) {
    return repo.findByTariffScheduleId(id);
  }

}
