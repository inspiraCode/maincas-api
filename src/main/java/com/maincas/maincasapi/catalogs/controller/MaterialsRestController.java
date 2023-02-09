package com.maincas.maincasapi.catalogs.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maincas.maincasapi.catalogs.model.Material;
import com.maincas.maincasapi.catalogs.model.MaterialAttachment;
import com.maincas.maincasapi.catalogs.model.MaterialUserComment;
import com.maincas.maincasapi.catalogs.service.MaterialAttachmentService;
import com.maincas.maincasapi.catalogs.service.MaterialService;
import com.maincas.maincasapi.catalogs.service.MaterialUserCommentService;
import com.maincas.maincasapi.controller.AbstractRestController;

@RestController
@RequestMapping(path = "/api/material", produces = MediaType.APPLICATION_JSON_VALUE)
public class MaterialsRestController
                extends
                AbstractRestController<Material, MaterialService, //
                                MaterialUserComment, MaterialUserCommentService, //
                                MaterialAttachment, MaterialAttachmentService> {

}
