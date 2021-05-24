package com.fpt.vn.controllers;

import com.fpt.vn.model.entitys.BookEntity;
import com.fpt.vn.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService iBookService;

    @GetMapping("/allByDoctor/{id}")
    public ResponseEntity allByDoctorIdDoctor(@PathVariable Long id) {
        List<BookEntity> list = iBookService.findAllByIdDoctor(id);
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/allByDoctorStatusFalse/{id}")
    public ResponseEntity allByDoctorStatusFalse(@PathVariable Long id) {
        List<BookEntity> list = iBookService.findAllByIdDoctorAndDateAfterAndStatusFalse(id);
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/allByDoctorByDate/{id}")
    public ResponseEntity allByDoctorIdDoctorByDate(@PathVariable Long id) {
        List<BookEntity> list = iBookService.findAllByIdDoctorAndDateAfter(id);
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createBooking(@RequestBody BookEntity bookEntity) {
        iBookService.save(bookEntity);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/checkBook/{id}")
    public ResponseEntity checkBooking(@PathVariable Long id) {
        List<BookEntity> list = iBookService.findAllByUserIdAndDoneFalse(id);
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/getBook/{id}")
    public ResponseEntity getBook(@PathVariable Long id) {
        BookEntity bookEntity = iBookService.findByUserId(id);
        return new ResponseEntity(bookEntity, HttpStatus.OK);
    }

    @GetMapping("/deleteBook/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id) {
        iBookService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/acceptBook/{id}")
    public ResponseEntity acceptBook(@PathVariable Long id) {
        iBookService.acceptBooking(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/allDone/{id}")
    public ResponseEntity findAllDone(@PathVariable Long id) {
        List<BookEntity> list = iBookService.findAllByIdDoctorAndDoneTrue(id);
        return new ResponseEntity(list,HttpStatus.OK);
    }
}
