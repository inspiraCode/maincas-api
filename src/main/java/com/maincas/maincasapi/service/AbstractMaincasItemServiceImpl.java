package com.maincas.maincasapi.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.model.Auditable;

public abstract class AbstractMaincasItemServiceImpl<T extends Auditable, U extends PagingAndSortingRepository<T, Long>>
        extends AbstractMaincasBaseServiceImpl<T, U> implements IMaincasItemService<T> {

}
