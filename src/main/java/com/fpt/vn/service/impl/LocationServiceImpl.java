package com.fpt.vn.service.impl;

import com.fpt.vn.model.entitys.LocationEntity;
import com.fpt.vn.repository.ILocationRepo;
import com.fpt.vn.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements ILocationService {
    @Autowired
    ILocationRepo iLocationRepo;

    @Override
    public void save(LocationEntity locationEntity) {
        iLocationRepo.save(locationEntity);
    }

    @Override
    public void edit(LocationEntity locationEntity) {
        iLocationRepo.save(locationEntity);
    }

    @Override
    public List<LocationEntity> findAll() {
        return iLocationRepo.findAll();
    }

    @Override
    public LocationEntity findByLatitude(double latitude) {
        return iLocationRepo.findLocation(latitude);
    }
}
