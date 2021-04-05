package com.fpt.vn.service;


import com.fpt.vn.model.entitys.ImgEntity;

import java.util.Optional;

public interface IImgService {
    void save(ImgEntity imgEntity);

    void delete(ImgEntity imgEntity);

    void edit(ImgEntity imgEntity);

    Iterable<ImgEntity> findAll();

    Iterable<ImgEntity> findAllByUserId(Long idUser);

    Iterable<ImgEntity> findAllByPostId(Long idUser);

    Optional<ImgEntity> findById(Long id);
}
