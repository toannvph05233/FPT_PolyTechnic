package com.fpt.vn.service.impl;

import com.fpt.vn.model.entitys.ImgEntity;
import com.fpt.vn.repository.IImgRepo;
import com.fpt.vn.service.IImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ImgServiceImpl implements IImgService {
    @Autowired
    IImgRepo iImgRepo;

    @Override
    public void save(ImgEntity imgEntity) {
        iImgRepo.save(imgEntity);
    }

    @Override
    public void delete(ImgEntity imgEntity) {
        iImgRepo.delete(imgEntity);
    }

    @Override
    public void edit(ImgEntity imgEntity) {
        iImgRepo.save(imgEntity);
    }

    @Override
    public Iterable<ImgEntity> findAll() {
        return iImgRepo.findAll();
    }

    @Override
    public Iterable<ImgEntity> findAllByUserId(Long idUser) {
        return iImgRepo.findAllByUserId(idUser);
    }

    @Override
    public Iterable<ImgEntity> findAllByPostId(Long idPost) {
        return null;
    }

    @Override
    public Optional<ImgEntity> findById(Long id) {
        return iImgRepo.findById(id);
    }
}
