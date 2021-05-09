package com.fpt.vn.repository;

import com.fpt.vn.model.entitys.CommentPost;
import com.fpt.vn.model.entitys.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepo extends JpaRepository<FeedbackEntity,Long> {
    long countByIdDoctor(Long id);

//    long sumCountsById(Long id);
}
