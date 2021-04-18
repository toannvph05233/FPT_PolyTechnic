package com.fpt.vn.repository;

import com.fpt.vn.model.entitys.LocationEntity;
import com.fpt.vn.model.entitys.MessengerEntity;
import com.fpt.vn.model.entitys.RomChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ILocationRepo extends JpaRepository<LocationEntity, Long> {
    @Query("SELECT f FROM LocationEntity f where f.latitude =:latitude")
    LocationEntity findLocation(@Param("latitude") double latitude);
}
