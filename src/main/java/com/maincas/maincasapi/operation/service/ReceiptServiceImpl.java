package com.maincas.maincasapi.operation.service;

import org.springframework.stereotype.Service;

import com.maincas.maincasapi.operation.model.Receipt;
import com.maincas.maincasapi.operation.repository.ReceiptRepository;
import com.maincas.maincasapi.service.AbstractMaincasServiceImpl;

@Service
public class ReceiptServiceImpl extends AbstractMaincasServiceImpl<Receipt, ReceiptRepository>
    implements ReceiptService {

}
