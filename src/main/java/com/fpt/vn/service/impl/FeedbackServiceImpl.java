package com.fpt.vn.service.impl;

import com.fpt.vn.model.entitys.FeedbackEntity;
import com.fpt.vn.repository.FeedbackRepo;
import com.fpt.vn.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackRepo feedbackRepo;
    @Override
    public Iterable<FeedbackEntity> findAll() {
        return feedbackRepo.findAll();
    }

    @Override
    public Long sumByIdDoctor(Long id) {
        return feedbackRepo.sumByIdDoctor(id).getSum();
    }

    @Override
    public List<FeedbackEntity> findAllByIdDoctor(Long id) {
        return feedbackRepo.findAllByIdDoctor(id);
    }

    @Override
    public Long countFeedbackByIdDoctor(Long id) {
        return feedbackRepo.countByIdDoctor(id);
    }

    @Override
    public Optional<FeedbackEntity> findById(Long id) {
        return feedbackRepo.findById(id);
    }

    @Override
    public void save(FeedbackEntity feedbackEntity) {
        feedbackRepo.save(feedbackEntity);
    }

    @Override
    public void delete(Long id) {
        feedbackRepo.deleteById(id);
    }
}
