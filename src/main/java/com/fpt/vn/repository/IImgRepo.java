package com.fpt.vn.repository;


import com.fpt.vn.model.entitys.ImgEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImgRepo extends JpaRepository<ImgEntity, Long> {
    public Iterable<ImgEntity> findAllByUserId(Long userId);
//    public Iterable<ImgEntity> findAllByPostEntityId(Long postId);
}
