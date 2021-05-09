package com.fpt.vn.service;

import com.fpt.vn.model.entitys.ApplyEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IApplyService {
    void save(ApplyEntity applyEntity);
    List<ApplyEntity> findAll();
    Optional<ApplyEntity> findApplyEntityById(Long id);
    List<ApplyEntity> findAllByPostEntityId(Long id);
    List<ApplyEntity> findAllByAppUserId(Long id);
    void delete(Long id);
    List<ApplyEntity> findAllWhoApply(Long id);


}
