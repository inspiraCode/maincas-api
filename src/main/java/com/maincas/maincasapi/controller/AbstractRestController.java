package com.maincas.maincasapi.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

import com.maincas.maincasapi.model.Auditable;
import com.maincas.maincasapi.service.IMaincasService;

public abstract class AbstractRestController<T extends Auditable, U extends IMaincasService<T>>
    extends AbstractBaseRestController<T, U> {

  private static final Logger logger = LoggerFactory.getLogger(AbstractRestController.class);

  @GetMapping(path = "/list")
  public List<T> entityList() {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    logger.info("LIST ALL {} records", t.toString());
    return service.fetchAll();
  }

}
