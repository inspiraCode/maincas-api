package com.maincas.maincasapi.catalogs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maincas.maincasapi.catalogs.model.PartNumberVendor;
import com.maincas.maincasapi.catalogs.repository.PartNumberVendorRepository;
import com.maincas.maincasapi.service.AbstractMaincasItemServiceImpl;

@Service
public class PartNumberVendorServiceImpl extends
    AbstractMaincasItemServiceImpl<PartNumberVendor, PartNumberVendorRepository> implements PartNumberVendorService {
  @Override
  public List<PartNumberVendor> fetchByParentId(Long id) {
    return repo.findByPartNumberId(id);
  }
}
