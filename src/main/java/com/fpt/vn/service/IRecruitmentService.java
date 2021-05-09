package com.fpt.vn.service;

import com.fpt.vn.model.entitys.RecruitmentEntity;

import java.util.List;
import java.util.Optional;

public interface IRecruitmentService {
    void save(RecruitmentEntity recruitmentEntity);
    void delete(Long id);
    List<RecruitmentEntity> findAll();
    Optional<RecruitmentEntity> findBRecruitmentEntityId(Long id);
}
