package com.fpt.vn.service;


import com.fpt.vn.model.entitys.CommentForm;

import java.util.Optional;

public interface CommentService {
    Iterable<CommentForm> findAll();

    Optional<CommentForm> findById(Long id);

    void save(CommentForm commentForm);

    void delete(Long id);
}
