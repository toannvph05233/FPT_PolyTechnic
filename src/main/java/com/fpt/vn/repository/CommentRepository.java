package com.fpt.vn.repository;


import com.fpt.vn.model.entitys.CommentPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentPost,Long> {
}
