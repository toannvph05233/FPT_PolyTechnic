package com.fpt.vn.controllers;

import com.fpt.vn.model.AppUser;
import com.fpt.vn.model.entitys.LocationEntity;
import com.fpt.vn.model.entitys.MessengerEntity;
import com.fpt.vn.service.ILocationService;
import com.fpt.vn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/location")
public class LocationController {
    @Autowired
    ILocationService iLocationService;

    @Autowired
    private UserService userService;

    @GetMapping("/allLocation")
    public ResponseEntity fillAllLocation() {
        List<LocationEntity> locationEntityList = iLocationService.findAll();
        return new ResponseEntity(locationEntityList, HttpStatus.OK);
    }

    @PostMapping("/createLocation")
    public ResponseEntity createLocation(@RequestBody LocationEntity locationEntity) {
        iLocationService.save(locationEntity);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/updateLocation/{idUser}")
    public ResponseEntity updateByUser(@PathVariable Long idUser, @RequestBody LocationEntity locationEntity) {
        List<LocationEntity> listLocation = iLocationService.findAll();
        LocationEntity newLocation;
        AppUser appUser = (userService.findById(idUser)).get();

        for (LocationEntity l : listLocation) {
            if (checkLocation(locationEntity.getLatitude(), locationEntity.getLongitude(), l.getLatitude(), l.getLongitude())) {
                newLocation = l;
                appUser.setLocationEntity(newLocation);
                userService.save(appUser);
                return new ResponseEntity(HttpStatus.OK);
            }
        }
        appUser.setLocationEntity(locationEntity);
        iLocationService.save(locationEntity);
        userService.save(appUser);
        return new ResponseEntity(HttpStatus.OK);
    }

    public boolean checkLocation(double latitude1, double longitude1, double latitude2, double longitude2) {
        //Converting to radians
        double longi1 = longitude1 * (Math.PI / 180);
        double longi2 = longitude2 * (Math.PI / 180);
        double lati1 = latitude1 * (Math.PI / 180);
        double lati2 = latitude2 * (Math.PI / 180);

        //Haversine Formula
        double difflong = longi2 - longi1;
        double difflat = lati2 - lati1;

        double val = Math.pow(Math.sin(difflat / 2), 2) + Math.cos(lati1) * Math.cos(lati2) * Math.pow(Math.sin(difflong / 2), 2);
        double res2 = 6378.8 * (2 * Math.asin(Math.sqrt(val))); //for kilometers
        if (res2 < 10) {
            return true;
        } else {
            return false;
        }
    }
}
