package com.maincas.maincasapi.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.model.Identifiable;

public abstract class AbstractMaincasItemServiceImpl<T extends Identifiable, U extends PagingAndSortingRepository<T, Long>>
        extends AbstractMaincasBaseServiceImpl<T, U> implements IMaincasItemService<T> {

}
