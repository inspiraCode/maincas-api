package com.maincas.maincasapi.catalogs.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maincas.maincasapi.catalogs.model.Company;
import com.maincas.maincasapi.catalogs.service.CompanyService;
import com.maincas.maincasapi.controller.AbstractRestController;

@RestController
@RequestMapping(path = "/api/company", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyRestController extends AbstractRestController<Company, CompanyService> {
  private static final Logger logger = LoggerFactory.getLogger(CompanyRestController.class);

  @GetMapping("/roles/{roleName}")
  public List<Company> companiesByRole(@PathVariable(name = "roleName") String roleName) {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    logger.info("LIST Company records with role {}", t.toString(), roleName);
    return service.fetchByRole(roleName);
  }
}
