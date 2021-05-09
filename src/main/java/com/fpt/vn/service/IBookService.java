package com.fpt.vn.service;

import com.fpt.vn.model.entitys.BookEntity;

import java.util.Optional;

public interface IBookService {
    Iterable<BookEntity> findAll();

    Optional<BookEntity> findById(Long id);

    void save(BookEntity commentPost);

    void delete(Long id);
}
