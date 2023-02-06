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

import com.maincas.maincasapi.operation.model.ReceiptItem;
import com.maincas.maincasapi.operation.service.ReceiptItemService;

@RestController
@RequestMapping(path = "/api/operations/receipt/{receiptId}/items", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReceiptItemRestController {
  @Autowired
  private ReceiptItemService service;

  @GetMapping(path = "/list")
  public List<ReceiptItem> receiptItemList(@PathVariable(name = "receiptId") Long receiptId) {
    return service.fetchReceiptItemsByReceiptId(receiptId);
  }

  @PostMapping("/create")
  public ReceiptItem create(@RequestBody ReceiptItem receiptItem) {
    return service.createReceiptItem(receiptItem);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getReceiptItemById(@PathVariable Long id) {
    return ResponseEntity.ok(service.fetchById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateReceipt(@PathVariable Long id, @RequestBody ReceiptItem receiptItem) {
    return ResponseEntity.ok(service.updateReceiptItem(id, receiptItem));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteReceiptItem(@PathVariable Long id) {
    Map<String, Boolean> map = new LinkedHashMap<>();
    service.deleteReceiptItemById(id);
    map.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(map);
  }

  @GetMapping("/{id}/revisions")
  @SuppressWarnings("rawtypes")
  public ResponseEntity<?> getRevisions(@PathVariable(name = "id") String receiptItemId,
      @RequestParam(value = "fetchChanges", required = false) boolean fetchChanges) {

    List results = service.getRevisions(Long.valueOf(receiptItemId), fetchChanges);
    return ResponseEntity.ok(results);
  }
}
