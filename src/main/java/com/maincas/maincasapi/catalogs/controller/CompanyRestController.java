package com.maincas.maincasapi.catalogs.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maincas.maincasapi.catalogs.model.Company;
import com.maincas.maincasapi.catalogs.model.CompanyAttachment;
import com.maincas.maincasapi.catalogs.model.CompanyUserComment;
import com.maincas.maincasapi.catalogs.service.CompanyAttachmentService;
import com.maincas.maincasapi.catalogs.service.CompanyService;
import com.maincas.maincasapi.catalogs.service.CompanyUserCommentService;
import com.maincas.maincasapi.controller.AbstractRestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/api/company", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class CompanyRestController
    extends
    AbstractRestController<Company, CompanyService, //
        CompanyUserComment, CompanyUserCommentService, //
        CompanyAttachment, CompanyAttachmentService> {

  @GetMapping("/roles/{roleName}")
  public List<Company> companiesByRole(@PathVariable String roleName) {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    log.info("LIST Company records with role {}", t.toString(), roleName);
    return service.fetchByRole(roleName);
  }
}
