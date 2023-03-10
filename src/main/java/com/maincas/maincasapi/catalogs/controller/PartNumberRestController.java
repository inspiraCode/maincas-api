package com.maincas.maincasapi.catalogs.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maincas.maincasapi.catalogs.model.PartNumber;
import com.maincas.maincasapi.catalogs.model.PartNumberAttachment;
import com.maincas.maincasapi.catalogs.model.PartNumberUserComment;
import com.maincas.maincasapi.catalogs.service.PartNumberAttachmentService;
import com.maincas.maincasapi.catalogs.service.PartNumberService;
import com.maincas.maincasapi.catalogs.service.PartNumberUserCommentService;
import com.maincas.maincasapi.controller.AbstractRestController;

@RestController
@RequestMapping(path = "/api/parts", produces = MediaType.APPLICATION_JSON_VALUE)
public class PartNumberRestController
        extends AbstractRestController<PartNumber, PartNumberService, //
                PartNumberUserComment, PartNumberUserCommentService, //
                PartNumberAttachment, PartNumberAttachmentService> {

}
