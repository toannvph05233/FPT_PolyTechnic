package com.fpt.vn.model.entitys;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "romchat")
@Data
public class RomChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String userFriend;
}
