package com.maincas.maincasapi.catalogs.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maincas.maincasapi.catalogs.model.TariffSchedule;
import com.maincas.maincasapi.catalogs.service.TariffScheduleService;

@RestController
@RequestMapping(path = "/api/tariff-schedule", produces = MediaType.APPLICATION_JSON_VALUE)
// TODO: Configure for production
@CrossOrigin(origins = "*")
public class TariffScheduleRestController {
  @Autowired
  private TariffScheduleService service;

  @GetMapping(path="/list")
  public List<TariffSchedule> TariffScheduleList() {
    return service.fetchAllTariffSchedules();
  }

  @PostMapping("/create")
  public TariffSchedule create(@RequestBody TariffSchedule tariffSchedule) {
    return service.createTariffSchedule(tariffSchedule);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getTariffScheduleById(@PathVariable Long id) {
    return ResponseEntity.ok(service.fetchById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateTariffSchedule(@PathVariable Long id, @RequestBody TariffSchedule TariffSchedule) {
    return ResponseEntity.ok(service.updateTariffSchedule(id, TariffSchedule));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteTariffSchedule(@PathVariable Long id) {
    Map<String, Boolean> map = new LinkedHashMap<>();
    service.deleteTariffScheduleById(id);
    map.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(map);
  }

  @GetMapping("/{id}/revisions")
  @SuppressWarnings("rawtypes")
  public ResponseEntity<?> getRevisions(@PathVariable(name = "id") String TariffScheduleId,
      @RequestParam(value = "fetchChanges", required = false) boolean fetchChanges) {

    List results = service.getRevisions(Long.valueOf(TariffScheduleId), fetchChanges);
    return ResponseEntity.ok(results);
  }
}
