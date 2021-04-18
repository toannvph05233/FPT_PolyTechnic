package com.fpt.vn.service;


import com.fpt.vn.model.entitys.MessengerEntity;

public interface IMessengerService {
    void save(MessengerEntity messengerEntity);

    Iterable<MessengerEntity> findAllByRomChatId(Long id);
}
