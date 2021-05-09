package com.fpt.vn.service.impl;

import com.fpt.vn.model.entitys.RecruitmentEntity;
import com.fpt.vn.repository.IRecruitmentRepo;
import com.fpt.vn.service.IRecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruitmentServiceImpl implements IRecruitmentService {
    @Autowired
    IRecruitmentRepo iRecruitmentRepo;

    @Override
    public void save(RecruitmentEntity recruitmentEntity) {
        iRecruitmentRepo.save(recruitmentEntity);
    }

    @Override
    public void delete(Long id) {
        iRecruitmentRepo.deleteById(id);
    }

    @Override
    public List<RecruitmentEntity> findAll() {
        return iRecruitmentRepo.findAll();
    }

    @Override
    public Optional<RecruitmentEntity> findBRecruitmentEntityId(Long id) {
        return iRecruitmentRepo.findById(id);
    }
}
