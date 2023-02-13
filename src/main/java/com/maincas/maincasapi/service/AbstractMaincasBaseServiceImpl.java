package com.maincas.maincasapi.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.model.Identifiable;

public abstract class AbstractMaincasBaseServiceImpl<T extends Identifiable, U extends JpaRepository<T, Long>>
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
  public Optional<T> fetchById(Long id) {
    return repo.findById(id);
  }

  @Override
  public T update(Long id, T entity) {
    entity.setId(id);
    return repo.save(entity);
  }

  @Override
  public List<?> getRevisions(Long id, boolean fetchChanges) {
    AuditQuery auditQuery = null;
    if (fetchChanges) {
      auditQuery = auditReader.createQuery()
          .forRevisionsOfEntityWithChanges(getType().getClass(), true);
    } else {
      auditQuery = auditReader.createQuery()
          .forRevisionsOfEntity(getType().getClass(), true);
    }
    auditQuery.add(AuditEntity.id().eq(id));
    return auditQuery.getResultList();
  }

  protected Type getType() {
    Type sooper = getClass().getGenericSuperclass();
    return ((ParameterizedType) sooper).getActualTypeArguments()[0];
  }
}
