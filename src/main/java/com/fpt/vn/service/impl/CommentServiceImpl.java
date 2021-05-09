package com.fpt.vn.service.impl;


import com.fpt.vn.model.entitys.CommentPost;
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
    public Iterable<CommentPost> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<CommentPost> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(CommentPost commentForm) {
        commentRepository.save(commentForm);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
