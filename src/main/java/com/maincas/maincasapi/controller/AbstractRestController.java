package com.maincas.maincasapi.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.maincas.maincasapi.model.Auditable;
import com.maincas.maincasapi.model.Identifiable;
import com.maincas.maincasapi.service.IMaincasItemService;
import com.maincas.maincasapi.service.IMaincasService;

public abstract class AbstractRestController<T extends Auditable, U extends IMaincasService<T>, V extends Identifiable, W extends IMaincasItemService<V>>
    extends AbstractBaseRestController<T, U> {

  private static final Logger logger = LoggerFactory.getLogger(AbstractRestController.class);
  @Autowired
  protected W commentsService;

  @GetMapping(path = "/list")
  public List<T> entityList() {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    logger.info("LIST ALL {} records", t.toString());
    return service.fetchAll();
  }

  @PostMapping("/{id}/comments/create")
  public V createUserComment(@RequestBody V entity) {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    logger.info("CREATING {} record with value {}", t.toString(), entity);
    V dbEntity = commentsService.create(entity);
    logger.info("Entity created, assigned id {}", dbEntity.getId());
    return dbEntity;
  }

  @PostMapping("/{id}/comments")
  public List<V> fetchUserComments(@PathVariable Long id) {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    logger.info("LIST all user comments for {} with  parent id {}", t.toString(), id);
    return commentsService.fetchByParentId(id);
  }

}
