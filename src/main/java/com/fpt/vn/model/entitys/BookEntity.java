package com.fpt.vn.model.entitys;

import com.fpt.vn.model.AppUser;
import lombok.Data;

import javax.persistence.*;
@Entity
@Data
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idDoctor;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private TimeEntity timeEntity;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;
}
