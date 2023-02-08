package com.maincas.maincasapi.catalogs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maincas.maincasapi.catalogs.model.TariffScheduleUserComment;
import com.maincas.maincasapi.catalogs.repository.TariffScheduleUserCommentRepository;
import com.maincas.maincasapi.service.AbstractUserCommentServiceImpl;

@Service
public class TariffScheduleUserCommentServiceImpl extends
    AbstractUserCommentServiceImpl<TariffScheduleUserComment, TariffScheduleUserCommentRepository>
    implements TariffScheduleUserCommentService {

  @Override
  public List<TariffScheduleUserComment> fetchByParentId(Long id) {
    return repo.findByTariffScheduleId(id);
  }

}
