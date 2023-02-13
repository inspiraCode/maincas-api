package com.maincas.maincasapi.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.model.Identifiable;

public abstract class AbstractMaincasItemServiceImpl<T extends Identifiable, U extends JpaRepository<T, Long>>
                extends AbstractMaincasBaseServiceImpl<T, U> implements IMaincasItemService<T> {

}
