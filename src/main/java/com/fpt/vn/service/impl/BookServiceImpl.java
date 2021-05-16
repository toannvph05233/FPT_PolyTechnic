package com.fpt.vn.service.impl;

import com.fpt.vn.model.entitys.BookEntity;
import com.fpt.vn.repository.BookRepo;
import com.fpt.vn.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
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

    @Override
    public List<BookEntity> findAllByIdDoctor(Long id) {
        return bookRepo.findAllByIdDoctor(id);
    }

    @Override
    public BookEntity findByUserId(Long id) {
        return bookRepo.findByUserId(id);
    }

    @Override
    public List<BookEntity> findAllByIdDoctorAndDateAfter(Long id) {
        long millis=System.currentTimeMillis();
        java.sql.Date date =new java.sql.Date(millis);
        return bookRepo.findAllByIdDoctorAndDateAfter(id,date);
    }

    @Override
    public List<BookEntity> findAllByUserIdAndDateAfterAndStatusTrue(Long id) {
        long millis=System.currentTimeMillis();
        java.sql.Date date =new java.sql.Date(millis);
        date.setDate(date.getDate()-1);
        return bookRepo.findAllByUserIdAndDateAfter(id,date);
    }
}
