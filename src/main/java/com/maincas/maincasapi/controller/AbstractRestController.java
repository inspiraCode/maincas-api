package com.maincas.maincasapi.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.maincas.maincasapi.model.Attachment;
import com.maincas.maincasapi.model.Auditable;
import com.maincas.maincasapi.model.UserComment;
import com.maincas.maincasapi.service.IMaincasItemService;
import com.maincas.maincasapi.service.IMaincasService;

public abstract class AbstractRestController<T extends Auditable, U extends IMaincasService<T>, V extends UserComment, W extends IMaincasItemService<V>, X extends Attachment, Y extends IMaincasItemService<X>>
    extends AbstractBaseRestController<T, U> {

  private static final Logger logger = LoggerFactory.getLogger(AbstractRestController.class);
  @Autowired
  protected W commentsService;

  @Autowired
  protected Y attachmentService;

  @GetMapping(path = "/list")
  public List<T> entityList() {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    logger.info("LIST ALL {} records", t.toString());
    return service.fetchAll();
  }

  @PostMapping("/{id}/comments/create")
  public ResponseEntity<V> createUserComment(@RequestBody V entity) {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    logger.info("CREATING {} record with value {}", t.toString(), entity);
    V dbEntity = commentsService.create(entity);
    logger.info("Entity created, assigned id {}", dbEntity.getId());
    return new ResponseEntity<V>(dbEntity, HttpStatus.CREATED);
  }

  @GetMapping("/{id}/comments")
  public List<V> fetchUserComments(@PathVariable Long id) {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    logger.info("LIST all user comments for {} with  parent id {}", t.toString(), id);
    return commentsService.fetchByParentId(id);
  }

  @PutMapping("/{id}/comments/{commentId}")
  public ResponseEntity<V> updateUserComment(@PathVariable Long id, @PathVariable Long commentId,
      @RequestBody V entity) {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    logger.info("UPDATE {} record with ID {}, set value {}", t.toString(), commentId, entity);
    V dbEntity = commentsService.update(commentId, entity);
    return ResponseEntity.ok(dbEntity);
  }

  @PostMapping("/{id}/attachments/create")
  public ResponseEntity<X> createAttachment(@RequestBody X entity) {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    logger.info("CREATING {} record with value {}", t.toString(), entity);
    X dbEntity = attachmentService.create(entity);
    logger.info("Entity created, assigned id {}", dbEntity.getId());
    return new ResponseEntity<X>(dbEntity, HttpStatus.CREATED);
  }

  @GetMapping("/{id}/attachments")
  public List<X> fetchAttachments(@PathVariable Long id) {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    logger.info("LIST all attachments for {} with  parent id {}", t.toString(), id);
    return attachmentService.fetchByParentId(id);
  }

  @GetMapping("/attachments/{id}")
  public ResponseEntity<X> downloadAttachment(@PathVariable Long id) {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    logger.info("DOWNLOAD attachment for {} with attachmentId {}", t.toString(), id);

    return attachmentService.fetchById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

}
