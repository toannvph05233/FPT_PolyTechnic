package com.fpt.vn.controllers;


import com.fpt.vn.model.entitys.RomChatEntity;
import com.fpt.vn.service.IRomChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RomChatController {
    @Autowired
    IRomChatService iRomChatService;

    @GetMapping("/findRomChat/{userName1}/{userName2}")
    public ResponseEntity<String> findRomChat(@PathVariable String userName1,@PathVariable String userName2) {
        RomChatEntity romChatEntity = iRomChatService.findRomChat(userName1,userName2);
        return new ResponseEntity(romChatEntity.getId(), HttpStatus.OK);
    }
}
