package com.fpt.vn.controllers;

import com.fpt.vn.model.entitys.ApplyEntity;
import com.fpt.vn.model.entitys.LocationEntity;
import com.fpt.vn.service.IApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/apply")
public class ApplyController {
    @Autowired
    IApplyService iApplyService;

    @GetMapping("/allApply")
    public ResponseEntity fillAllApply() {
        List<ApplyEntity> applyEntities = iApplyService.findAll();
        return new ResponseEntity(applyEntities, HttpStatus.OK);
    }

    @GetMapping("/allApplyByPost/{idPost}")
    public ResponseEntity fillAllApplyByPost(@PathVariable Long idPost) {
        List<ApplyEntity> applyEntities = iApplyService.findAllByPostEntityId(idPost);
        return new ResponseEntity(applyEntities, HttpStatus.OK);
    }
    @GetMapping("/allWhoApply/{idUser}")
    public ResponseEntity fillAllWhoApply(@PathVariable Long idUser) {
        List<ApplyEntity> applyEntities = iApplyService.findAllWhoApply(idUser);
        return new ResponseEntity(applyEntities, HttpStatus.OK);
    }

    @GetMapping("/allApplyByUser/{idUser}")
    public ResponseEntity fillAllApplyByUser(@PathVariable Long idUser) {
        List<ApplyEntity> applyEntities = iApplyService.findAllByAppUserId(idUser);
        return new ResponseEntity(applyEntities, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createApply(@RequestBody ApplyEntity applyEntity) {
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        applyEntity.setDate(date);
        iApplyService.save(applyEntity);
        return new ResponseEntity(HttpStatus.OK);

    }

    @GetMapping("/delete/{idApply}")
    public ResponseEntity deleteApply(@PathVariable Long idApply) {
        iApplyService.delete(idApply);
        return new ResponseEntity(HttpStatus.OK);
    }

}
