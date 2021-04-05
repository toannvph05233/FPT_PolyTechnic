package com.fpt.vn.repository;

import com.fpt.vn.model.entitys.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPostRepository extends JpaRepository<PostEntity, Long> {
    @Modifying
    @Query("UPDATE PostEntity p SET p.status = 1 WHERE p.id =:id")
    void changStatusPostTrue(@Param("id") Long id);

    @Modifying
    @Query("UPDATE PostEntity p SET p.status = 0 WHERE p.id =:id")
    void changStatusPostFalse(@Param("id") Long id);

    Iterable<PostEntity> findByContentContainingAndUserId(String content, Long id);

    Optional<PostEntity> findById(Long id);

    Iterable<PostEntity> findAllByUserId(Long id);

    Iterable<PostEntity> findAllByStatus(int status);


}
