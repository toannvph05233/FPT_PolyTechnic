package com.fpt.vn.controllers;


import com.fpt.vn.model.AppUser;
import com.fpt.vn.model.Messenger;
import com.fpt.vn.model.UserSocket;
import com.fpt.vn.model.entitys.MessengerEntity;
import com.fpt.vn.model.entitys.RomChatEntity;
import com.fpt.vn.service.IMessengerService;
import com.fpt.vn.service.IRomChatService;
import com.fpt.vn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController<IMessengerService> {
  private String userNameFriend;
  private Long idRomChat;
  RomChatEntity romChatEntity;

  @Autowired
  SimpMessagingTemplate simpMessagingTemplate;

  @Autowired
  com.fpt.vn.service.IMessengerService iMessengerService;

  @Autowired
  IRomChatService iRomChatService;

  @Autowired
  private UserService userService;

  @MessageMapping("/chat.newUser")
  public void greeting(@Payload Messenger messenger) {
    AppUser user = userService.findByUsername(messenger.getName());
    MessengerEntity messengerEntity = new MessengerEntity();
    messengerEntity.setAppUser(user);
    messengerEntity.setRomChatEntity(romChatEntity);
    messengerEntity.setMessenger(messenger.getMessage());

    iMessengerService.save(messengerEntity);
    simpMessagingTemplate.convertAndSend("/topic/public/"+ this.idRomChat, messenger.getName() +" : " + messenger.getMessage());

  }
  @MessageMapping("/chatVsUser")
  public UserSocket chatVsUser(@Payload UserSocket user) {
    this.userNameFriend = user.getUserNameFriend();
    romChatEntity = iRomChatService.findRomChat(user.getName(),user.getUserNameFriend());
    this.idRomChat = romChatEntity.getId();
    System.out.println("------------------------------");
    System.out.println(user);
    System.out.println("------------------------------");
    return user;
  }

}
