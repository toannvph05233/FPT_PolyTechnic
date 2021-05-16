package com.fpt.vn.controllers;

import com.fpt.vn.model.entitys.ApplyEntity;
import com.fpt.vn.model.entitys.FeedbackEntity;
import com.fpt.vn.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @GetMapping("/count/{id}")
    public ResponseEntity countFeedbackByIdDoctor(@PathVariable Long id) {
        Long count = feedbackService.countFeedbackByIdDoctor(id);
        return new ResponseEntity(count, HttpStatus.OK);
    }

    @GetMapping("/allFeedback/{id}")
    public ResponseEntity findAllByDoctor(@PathVariable Long id) {
        List<FeedbackEntity> list = feedbackService.findAllByIdDoctor(id);
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/percent/{id}")
    public ResponseEntity percentByIdDoctor(@PathVariable Long id) {
        Long sum = feedbackService.sumByIdDoctor(id);
        Long count = feedbackService.countFeedbackByIdDoctor(id);
        int percent = (int) (sum / count);
        return new ResponseEntity(percent, HttpStatus.OK);
    }
}
