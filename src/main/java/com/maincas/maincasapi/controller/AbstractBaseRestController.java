package com.maincas.maincasapi.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.maincas.maincasapi.model.Auditable;
import com.maincas.maincasapi.service.IMaincasBaseService;

@CrossOrigin(origins = "http://localhost:4200")
public abstract class AbstractBaseRestController<T extends Auditable, U extends IMaincasBaseService<T>> {
  private static final Logger logger = LoggerFactory.getLogger(AbstractBaseRestController.class);
  @Autowired
  protected U service;

  @PostMapping("/create")
  public ResponseEntity<T> create(@RequestBody T entity) {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    logger.info("CREATING {} record with value {}", t.toString(), entity);
    T dbEntity = service.create(entity);
    logger.info("Entity created, assigned id {}", dbEntity.getId());
    return new ResponseEntity<T>(dbEntity, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<T> getById(@PathVariable Long id) {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    logger.info("GET {} record with ID {}", t.toString(), id);

    return service.fetchById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<T> update(@PathVariable Long id, @RequestBody T entity) {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    logger.info("UPDATE {} record with ID {}, set value {}", t.toString(), id, entity);

    Optional<T> dbEntity = service.fetchById(id);
    if (dbEntity.isPresent()) {
      return ResponseEntity.ok(service.update(id, entity));
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    logger.info("DELETE {} record with ID {}", t.toString(), id);

    Optional<T> dbEntity = service.fetchById(id);
    if (dbEntity.isPresent()) {
      service.deleteById(id);
      Map<String, Boolean> map = new LinkedHashMap<>();
      map.put("deleted", Boolean.TRUE);
      return ResponseEntity.ok(map);
    } else {
      return ResponseEntity.notFound().build();
    }

  }

  @GetMapping("/{id}/revisions")
  @SuppressWarnings("rawtypes")
  public ResponseEntity<?> getRevisions(@PathVariable(name = "id") String id,
      @RequestParam(value = "fetchChanges", required = false) boolean fetchChanges) {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    logger.info("AUDIT LOG {} record with ID {}, fetchChanges? {}", t.toString(), id, fetchChanges);

    List results = service.getRevisions(Long.valueOf(id), fetchChanges);
    return ResponseEntity.ok(results);
  }
}
