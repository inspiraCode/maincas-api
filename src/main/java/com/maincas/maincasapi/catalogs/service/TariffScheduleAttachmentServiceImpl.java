package com.maincas.maincasapi.catalogs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maincas.maincasapi.catalogs.model.TariffScheduleAttachment;
import com.maincas.maincasapi.catalogs.repository.TariffScheduleAttachmentRepository;
import com.maincas.maincasapi.service.AbstractAttachmentServiceImpl;

@Service
public class TariffScheduleAttachmentServiceImpl
    extends AbstractAttachmentServiceImpl<TariffScheduleAttachment, TariffScheduleAttachmentRepository>
    implements TariffScheduleAttachmentService {

  @Override
  public List<TariffScheduleAttachment> fetchByParentId(Long id) {
    return repo.findByTariffScheduleId(id);
  }
}
