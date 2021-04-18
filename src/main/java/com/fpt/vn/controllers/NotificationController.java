package com.fpt.vn.controllers;

import com.fpt.vn.model.AppUser;
import com.fpt.vn.model.Notification;
import com.fpt.vn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {
    @Autowired
    private UserService userService;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/notification")
    public void greeting(@Payload Notification notification) {
        AppUser user = userService.findByUsername(notification.getUserName());
        simpMessagingTemplate.convertAndSend("/topic/public/"+user.getLocationEntity().getId(), notification.getUserName() + " đã có hoạt động " + notification.getContent());

    }
}
