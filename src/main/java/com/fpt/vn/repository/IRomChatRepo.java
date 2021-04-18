package com.fpt.vn.repository;

import com.fpt.vn.model.entitys.RomChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRomChatRepo extends JpaRepository<RomChatEntity, Long> {
    @Query("SELECT f FROM RomChatEntity f where (f.userFriend =:userName1 and f.userName =:userName2) or (f.userFriend =:userName2 and f.userName =:userName1)")
    public RomChatEntity findChatRom(@Param("userName1") String userName1, @Param("userName2") String userName2);

}
