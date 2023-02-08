package com.maincas.maincasapi.catalogs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maincas.maincasapi.catalogs.model.PartNumber;
import com.maincas.maincasapi.catalogs.repository.PartNumberRepository;
import com.maincas.maincasapi.service.AbstractMaincasServiceImpl;

@Service
public class PartNumberServiceImpl extends AbstractMaincasServiceImpl<PartNumber, PartNumberRepository>
        implements PartNumberService {

    @Override
    public List<PartNumber> fetchByBuyerId(Long buyerId) {
        return repo.findByBuyerId(buyerId);
    }

    @Override
    public List<PartNumber> fetchByMaterialId(Long materialId) {
        return repo.findByMaterialId(materialId);
    }

}
