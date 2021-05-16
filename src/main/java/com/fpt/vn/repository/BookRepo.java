package com.fpt.vn.repository;

import com.fpt.vn.model.entitys.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface BookRepo extends JpaRepository<BookEntity,Long> {
    List<BookEntity> findAllByIdDoctor(Long id);
    List<BookEntity> findAllByIdDoctorAndDateAfter(Long id, Date date);
    List<BookEntity> findAllByUserIdAndDateAfter(Long id, Date date);
    BookEntity findByUserId(Long id);

}
