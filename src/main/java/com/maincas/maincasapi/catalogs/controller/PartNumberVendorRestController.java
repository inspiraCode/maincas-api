package com.maincas.maincasapi.catalogs.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maincas.maincasapi.catalogs.model.PartNumberVendor;
import com.maincas.maincasapi.catalogs.service.PartNumberVendorService;
import com.maincas.maincasapi.controller.AbstractItemRestController;

@RestController
@RequestMapping(path = "/api/operations/parts/{parentId}/vendors", produces = MediaType.APPLICATION_JSON_VALUE)
public class PartNumberVendorRestController
    extends AbstractItemRestController<PartNumberVendor, PartNumberVendorService> {

}
