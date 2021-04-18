package com.fpt.vn.service;


import com.fpt.vn.model.entitys.RomChatEntity;

public interface IRomChatService {
    void save(RomChatEntity romChatEntity);
    RomChatEntity findRomChat(String userName1, String userName2);
}
