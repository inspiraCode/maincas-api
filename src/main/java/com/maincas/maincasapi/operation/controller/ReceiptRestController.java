package com.maincas.maincasapi.operation.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maincas.maincasapi.controller.AbstractRestController;
import com.maincas.maincasapi.operation.model.Receipt;
import com.maincas.maincasapi.operation.model.ReceiptAttachment;
import com.maincas.maincasapi.operation.model.ReceiptUserComment;
import com.maincas.maincasapi.operation.service.ReceiptAttachmentService;
import com.maincas.maincasapi.operation.service.ReceiptService;
import com.maincas.maincasapi.operation.service.ReceiptUserCommentService;

@RestController
@RequestMapping(path = "/api/operations/receipt", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReceiptRestController
        extends AbstractRestController<Receipt, ReceiptService, //
                ReceiptUserComment, ReceiptUserCommentService, //
                ReceiptAttachment, ReceiptAttachmentService> {

}
