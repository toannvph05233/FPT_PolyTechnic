package com.fpt.vn.service;


import com.fpt.vn.model.entitys.PostEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostService {
    void savePost(PostEntity postEntity);

    void deletePost(PostEntity postEntity);

    void changStatusPostTrue(Long id);

    void changStatusPostFalse(Long id);

    void editPost(PostEntity postEntity);

    List<PostEntity> findPostNotApply(Long id);

    Iterable<PostEntity> findAll();

    Iterable<PostEntity> findAllByStatus(int status);

    Iterable<PostEntity> findAllByUserId(Long idUser);

    Iterable<PostEntity> findAllByContent(String content,Long id);

    Optional<PostEntity> findById(Long id);
}
