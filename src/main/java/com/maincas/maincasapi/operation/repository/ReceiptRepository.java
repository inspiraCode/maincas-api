package com.maincas.maincasapi.operation.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.operation.model.Receipt;

public interface ReceiptRepository extends PagingAndSortingRepository<Receipt, Long> {
  
}
