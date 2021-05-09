package com.fpt.vn.controllers;

import com.fpt.vn.model.entitys.ApplyEntity;
import com.fpt.vn.model.entitys.RecruitmentEntity;
import com.fpt.vn.repository.IRecruitmentRepo;
import com.fpt.vn.service.IApplyService;
import com.fpt.vn.service.IRecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/recruitment")
public class RecruitmentController {
    @Autowired
    IRecruitmentService iRecruitmentRepo;

    @Autowired
    IApplyService iApplyService;

    @GetMapping("/allRecruit")
    public ResponseEntity fillAll() {
        List<RecruitmentEntity> recruitmentEntityList = iRecruitmentRepo.findAll();
        return new ResponseEntity(recruitmentEntityList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody RecruitmentEntity recruitmentEntity) {
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        recruitmentEntity.setDate(date);
        ApplyEntity applyEntity = iApplyService.findApplyEntityById(recruitmentEntity.getApplyEntity().getId()).get();
        applyEntity.setStatus(1);
        iApplyService.save(applyEntity);
        iRecruitmentRepo.save(recruitmentEntity);
        return new ResponseEntity(HttpStatus.OK);

    }

    @GetMapping("/delete/{idRecruit}")
    public ResponseEntity delete(@PathVariable Long idRecruit) {
        iRecruitmentRepo.delete(idRecruit);
        return new ResponseEntity(HttpStatus.OK);
    }


}
