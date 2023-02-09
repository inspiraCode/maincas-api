package com.maincas.maincasapi.catalogs.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maincas.maincasapi.catalogs.model.TariffSchedule;
import com.maincas.maincasapi.catalogs.model.TariffScheduleAttachment;
import com.maincas.maincasapi.catalogs.model.TariffScheduleUserComment;
import com.maincas.maincasapi.catalogs.service.TariffScheduleAttachmentService;
import com.maincas.maincasapi.catalogs.service.TariffScheduleService;
import com.maincas.maincasapi.catalogs.service.TariffScheduleUserCommentService;
import com.maincas.maincasapi.controller.AbstractRestController;

@RestController
@RequestMapping(path = "/api/tariff-schedule", produces = MediaType.APPLICATION_JSON_VALUE)
public class TariffScheduleRestController extends
        AbstractRestController<TariffSchedule, TariffScheduleService, //
                TariffScheduleUserComment, TariffScheduleUserCommentService, //
                TariffScheduleAttachment, TariffScheduleAttachmentService> {

}
