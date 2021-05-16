package com.fpt.vn.service;

import com.fpt.vn.model.entitys.CommentPost;
import com.fpt.vn.model.entitys.FeedbackEntity;

import java.util.List;
import java.util.Optional;

public interface FeedbackService {
    Iterable<FeedbackEntity> findAll();
    Long sumByIdDoctor(Long id);
    List<FeedbackEntity> findAllByIdDoctor(Long id);
    Long countFeedbackByIdDoctor(Long id);

    Optional<FeedbackEntity> findById(Long id);

    void save(FeedbackEntity feedbackEntity);

    void delete(Long id);
}
