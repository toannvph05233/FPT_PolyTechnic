package com.fpt.vn.repository;

import com.fpt.vn.model.entitys.ApplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IApplyRepo extends JpaRepository<ApplyEntity, Long> {
    List<ApplyEntity> findAllByPostEntityId(Long id);
    List<ApplyEntity> findAllByAppUserId(Long id);
    @Query("SELECT a FROM ApplyEntity a inner join PostEntity p on p.id = a.postEntity.id where p.user.id =:id and a.status=0")
    List<ApplyEntity> findAllWhoApply(@Param("id") Long id);
}
