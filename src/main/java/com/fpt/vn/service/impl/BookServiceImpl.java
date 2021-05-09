package com.fpt.vn.service.impl;

import com.fpt.vn.model.entitys.BookEntity;
import com.fpt.vn.repository.BookRepo;
import com.fpt.vn.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    BookRepo bookRepo;

    @Override
    public Iterable<BookEntity> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Optional<BookEntity> findById(Long id) {
        return bookRepo.findById(id);
    }

    @Override
    public void save(BookEntity bookEntity) {
        bookRepo.save(bookEntity);
    }

    @Override
    public void delete(Long id) {
        bookRepo.deleteById(id);
    }
}
