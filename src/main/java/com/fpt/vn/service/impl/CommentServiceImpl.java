package com.fpt.vn.service.impl;


import com.fpt.vn.model.entitys.CommentForm;
import com.fpt.vn.repository.CommentRepository;
import com.fpt.vn.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;


    @Override
    public Iterable<CommentForm> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<CommentForm> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(CommentForm commentForm) {
        commentRepository.save(commentForm);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
