package com.fpt.vn.service;



import com.fpt.vn.model.entitys.CommentPost;

import java.util.Optional;

public interface CommentService {
    Iterable<CommentPost> findAll();

    Optional<CommentPost> findById(Long id);

    void save(CommentPost commentPost);

    void delete(Long id);
}
