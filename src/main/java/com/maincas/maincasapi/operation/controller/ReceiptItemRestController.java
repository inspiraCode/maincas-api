package com.maincas.maincasapi.operation.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maincas.maincasapi.controller.AbstractItemRestController;
import com.maincas.maincasapi.operation.model.ReceiptItem;
import com.maincas.maincasapi.operation.service.ReceiptItemService;

@RestController
@RequestMapping(path = "/api/operations/receipt/{receiptId}/items", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReceiptItemRestController extends AbstractItemRestController<ReceiptItem, ReceiptItemService> {

}
