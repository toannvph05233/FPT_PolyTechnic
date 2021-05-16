package com.fpt.vn.repository;

import com.fpt.vn.model.entitys.FeedbackEntity;
import com.fpt.vn.model.query.SumFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FeedbackRepo extends JpaRepository<FeedbackEntity,Long> {
    long countByIdDoctor(Long id);

    List<FeedbackEntity> findAllByIdDoctor(Long id);

    @Query(value = "SELECT sum(counts) as sum FROM feedback where id_doctor = ?1",nativeQuery = true)
    SumFeedback sumByIdDoctor(Long id);
}
