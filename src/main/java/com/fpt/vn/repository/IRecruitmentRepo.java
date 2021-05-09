package com.fpt.vn.repository;

import com.fpt.vn.model.entitys.MessengerEntity;
import com.fpt.vn.model.entitys.RecruitmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecruitmentRepo extends JpaRepository<RecruitmentEntity, Long> {

}
