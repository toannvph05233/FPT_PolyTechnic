package com.fpt.vn.service.impl;


import com.fpt.vn.model.entitys.MessengerEntity;
import com.fpt.vn.repository.IMessengerRepo;
import com.fpt.vn.service.IMessengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessengerServiceImpl implements IMessengerService {
    @Autowired
    IMessengerRepo iMessengerRepo;
    @Override
    public void save(MessengerEntity messengerEntity) {
        iMessengerRepo.save(messengerEntity);
    }

    @Override
    public Iterable<MessengerEntity> findAllByRomChatId(Long id) {
        return iMessengerRepo.findAllByRomChatEntityId(id);
    }
}
