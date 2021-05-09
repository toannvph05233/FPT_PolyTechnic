package com.fpt.vn.service.impl;


import com.fpt.vn.model.entitys.PostEntity;
import com.fpt.vn.repository.IPostRepository;
import com.fpt.vn.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private IPostRepository iPostRepository;

    @Override
    public void savePost(PostEntity postEntity) {
        iPostRepository.save(postEntity);
    }

    @Override
    public void deletePost(PostEntity postEntity) {
        iPostRepository.delete(postEntity);
    }

    @Override
    @Transactional
    public void changStatusPostTrue(Long id) {
        iPostRepository.changStatusPostTrue(id);
    }

    @Override
    @Transactional
    public void changStatusPostFalse(Long id) {
        iPostRepository.changStatusPostFalse(id);
    }


    @Override
    public void editPost(PostEntity postEntity) {
        iPostRepository.save(postEntity);
    }

    @Override
    public List<PostEntity> findPostNotApply(Long id) {
        return iPostRepository.findPostNotApply(id);
    }

    @Override
    public Iterable<PostEntity> findAll() {
        return iPostRepository.findAll();
    }

    @Override
    public Iterable<PostEntity> findAllByStatus(int status) {
        return iPostRepository.findAllByStatus(status);
    }

    @Override
    public Iterable<PostEntity> findAllByUserId(Long idUser) {
        return iPostRepository.findAllByUserId(idUser);
    }
    @Override
    public Iterable<PostEntity> findAllByContent(String content, Long id) {
        return iPostRepository.findByContentContainingAndUserId(content, id);
    }

    @Override
    public Optional<PostEntity> findById(Long id) {
        return iPostRepository.findById(id);
    }
}
