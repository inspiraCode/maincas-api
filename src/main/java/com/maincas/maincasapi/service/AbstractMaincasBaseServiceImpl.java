package com.maincas.maincasapi.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.model.Identifiable;

public abstract class AbstractMaincasBaseServiceImpl<T extends Identifiable, U extends PagingAndSortingRepository<T, Long>>
    implements IMaincasBaseService<T> {
  @Autowired
  protected U repo;

  @Autowired
  protected AuditReader auditReader;

  @Override
  public T create(T entity) {
    return repo.save(entity);
  }

  @Override
  public void deleteById(Long id) {
    repo.deleteById(id);
  }

  @Override
  public T fetchById(Long id) {
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
    return repo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException(String.format("Unable to find {} by id {}", t.toString(), id)));
  }

  @Override
  public T update(Long id, T entity) {
    entity.setId(id);
    return repo.save(entity);
  }

  @Override
  public List<?> getRevisions(Long id, boolean fetchChanges) {
    AuditQuery auditQuery = null;
    Type sooper = getClass().getGenericSuperclass();
    Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];

    if (fetchChanges) {
      auditQuery = auditReader.createQuery()
          .forRevisionsOfEntityWithChanges(t.getClass(), true);
    } else {
      auditQuery = auditReader.createQuery()
          .forRevisionsOfEntity(t.getClass(), true);
    }
    auditQuery.add(AuditEntity.id().eq(id));
    return auditQuery.getResultList();
  }
}
