package com.maincas.maincasapi.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.maincas.maincasapi.model.Auditable;
import com.maincas.maincasapi.service.IMaincasItemService;

public abstract class AbstractItemRestController<T extends Auditable, U extends IMaincasItemService<T>>
    extends AbstractBaseRestController<T, U> {
  private static final Logger logger = LoggerFactory.getLogger(AbstractItemRestController.class);

  @GetMapping(path = "/list")
  public List<T> entityList(@PathVariable Long parentId) {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    logger.info("LIST {} records using PARENT ID {}", t.toString(), parentId);
    return service.fetchByParentId(parentId);
  }
}
