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

import com.maincas.maincasapi.catalogs.model.Company;
import com.maincas.maincasapi.catalogs.service.CompanyService;

@RestController
@RequestMapping(path = "/api/company", produces = MediaType.APPLICATION_JSON_VALUE)
// TODO: Configure for production
@CrossOrigin(origins = "*")
public class CompanyRestController {
  @Autowired
  private CompanyService service;

  @GetMapping(path="/list")
  public List<Company> companyList() {
    return service.fetchAllCompanies();
  }

  @PostMapping("/create")
  public Company create(@RequestBody Company company) {
    return service.createCompany(company);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getCompanyById(@PathVariable Long id) {
    return ResponseEntity.ok(service.fetchById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateCompany(@PathVariable Long id, @RequestBody Company company) {
    return ResponseEntity.ok(service.updateCompany(id, company));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteCompany(@PathVariable Long id) {
    Map<String, Boolean> map = new LinkedHashMap<>();
    service.deleteCompanyById(id);
    map.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(map);
  }

  @GetMapping("/{id}/revisions")
  @SuppressWarnings("rawtypes")
  public ResponseEntity<?> getRevisions(@PathVariable(name = "id") String companyId,
      @RequestParam(value = "fetchChanges", required = false) boolean fetchChanges) {

    List results = service.getRevisions(Long.valueOf(companyId), fetchChanges);
    return ResponseEntity.ok(results);
  }
}
