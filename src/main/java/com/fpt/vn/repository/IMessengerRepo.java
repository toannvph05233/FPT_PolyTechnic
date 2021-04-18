package com.fpt.vn.repository;

import com.fpt.vn.model.entitys.MessengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMessengerRepo extends JpaRepository<MessengerEntity, Long> {
    public Iterable<MessengerEntity> findAllByRomChatEntityId(Long id);

}
