package com.maincas.maincasapi.service;

import java.util.List;
import java.util.Optional;

public interface IMaincasBaseService<T> {
  Optional<T> fetchById(Long id);

  T update(Long id, T entity);

  T create(T entity);

  void deleteById(Long id);

  List<?> getRevisions(Long id, boolean fetchChanges);
}
