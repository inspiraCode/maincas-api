package com.maincas.maincasapi.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.model.Identifiable;

public abstract class AbstractMaincasServiceImpl<T extends Identifiable, U extends JpaRepository<T, Long>>
    extends AbstractMaincasBaseServiceImpl<T, U> implements IMaincasService<T> {

  @Override
  public List<T> fetchAll() {
    return StreamSupport.stream(repo.findAll().spliterator(), false).collect(Collectors.toList());
  }

}
