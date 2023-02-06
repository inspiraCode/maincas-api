package com.maincas.maincasapi.operation.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maincas.maincasapi.operation.model.Receipt;
import com.maincas.maincasapi.operation.service.ReceiptService;

@RestController
@RequestMapping(path = "/api/operations/receipt", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReceiptRestController {
  @Autowired
  private ReceiptService service;

  @GetMapping(path = "/list")
  public List<Receipt> ReceiptList() {
    return service.fetchAllReceipts();
  }

  @PostMapping("/create")
  public Receipt create(@RequestBody Receipt receipt) {
    return service.createReceipt(receipt);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getReceiptById(@PathVariable Long id) {
    return ResponseEntity.ok(service.fetchById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateReceipt(@PathVariable Long id, @RequestBody Receipt receipt) {
    return ResponseEntity.ok(service.updateReceipt(id, receipt));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteReceipt(@PathVariable Long id) {
    Map<String, Boolean> map = new LinkedHashMap<>();
    service.deleteReceiptById(id);
    map.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(map);
  }

  @GetMapping("/{id}/revisions")
  @SuppressWarnings("rawtypes")
  public ResponseEntity<?> getRevisions(@PathVariable(name = "id") String receiptId,
      @RequestParam(value = "fetchChanges", required = false) boolean fetchChanges) {

    List results = service.getRevisions(Long.valueOf(receiptId), fetchChanges);
    return ResponseEntity.ok(results);
  }
}
