package com.fpt.vn.service.impl;

import com.fpt.vn.model.entitys.ApplyEntity;
import com.fpt.vn.repository.IApplyRepo;
import com.fpt.vn.service.IApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ApplyServiceImpl implements IApplyService {
    @Autowired
    IApplyRepo iApplyRepo;

    @Override
    public void save(ApplyEntity applyEntity) {
        iApplyRepo.save(applyEntity);
    }

    @Override
    public List<ApplyEntity> findAll() {
        return iApplyRepo.findAll();
    }

    @Override
    public Optional<ApplyEntity> findApplyEntityById(Long id) {
        return iApplyRepo.findById(id);
    }

    @Override
    public List<ApplyEntity> findAllByPostEntityId(Long id) {
        return iApplyRepo.findAllByPostEntityId(id);
    }

    @Override
    public List<ApplyEntity> findAllByAppUserId(Long id) {
        return iApplyRepo.findAllByAppUserId(id);
    }

    @Override
    public void delete(Long id) {
         iApplyRepo.deleteById(id);
    }

    @Override
    public List<ApplyEntity> findAllWhoApply(Long id) {
        return iApplyRepo.findAllWhoApply(id);
    }
}
