package com.fpt.vn.controllers;

import com.fpt.vn.model.entitys.MessengerEntity;
import com.fpt.vn.model.entitys.RomChatEntity;
import com.fpt.vn.service.IMessengerService;
import com.fpt.vn.service.IRomChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ChatControllerAPI {
    @Autowired
    IRomChatService iRomChatService;
    @Autowired
    IMessengerService iMessengerService;

    @GetMapping("/addRomchat/{user1}/{user2}")
    public ResponseEntity addRomchat(@PathVariable String user1,@PathVariable String user2) {
       RomChatEntity romChatEntity = iRomChatService.findRomChat(user1,user2);
       if (romChatEntity == null){
           romChatEntity = new RomChatEntity();
           romChatEntity.setUserName(user1);
           romChatEntity.setUserFriend(user2);
           iRomChatService.save(romChatEntity);
       }
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/allChat/{idRomChat}")
    public ResponseEntity fillAllChatByRom(@PathVariable Long idRomChat) {
        Iterable<MessengerEntity> listMessenger = iMessengerService.findAllByRomChatId(idRomChat);
        return new ResponseEntity(listMessenger,HttpStatus.OK);
    }

}
