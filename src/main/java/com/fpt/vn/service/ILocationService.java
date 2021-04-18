package com.fpt.vn.service;


import com.fpt.vn.model.entitys.LocationEntity;

import java.util.List;
import java.util.Optional;

public interface ILocationService {
    void save(LocationEntity locationEntity);
    void edit(LocationEntity locationEntity);

    List<LocationEntity> findAll();
    LocationEntity findByLatitude(double latitude);
}
