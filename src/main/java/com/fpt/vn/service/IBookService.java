package com.fpt.vn.service;

import com.fpt.vn.model.entitys.BookEntity;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface IBookService {
    Iterable<BookEntity> findAll();

    Optional<BookEntity> findById(Long id);

    void save(BookEntity commentPost);

    void delete(Long id);

    List<BookEntity> findAllByIdDoctor(Long id);
    BookEntity findByUserId(Long id);

    List<BookEntity> findAllByIdDoctorAndDateAfter(Long id);
    List<BookEntity> findAllByUserIdAndDateAfterAndStatusTrue(Long id);


}
