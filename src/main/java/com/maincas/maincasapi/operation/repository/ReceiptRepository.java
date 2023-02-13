package com.maincas.maincasapi.operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.operation.model.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

}
