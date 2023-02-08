package com.maincas.maincasapi.catalogs.service;

import java.util.List;

import com.maincas.maincasapi.catalogs.model.PartNumber;
import com.maincas.maincasapi.service.IMaincasService;

public interface PartNumberService extends IMaincasService<PartNumber> {
  List<PartNumber> fetchByBuyerId(Long buyerId);
  List<PartNumber> fetchByMaterialId(Long materialId);
}
