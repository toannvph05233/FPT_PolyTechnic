package com.fpt.vn.model.entitys;

import com.fpt.vn.model.AppUser;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idDoctor;
    private String comment;
    private Date date;
    private boolean status;
    private boolean done;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private TimeEntity timeEntity;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;
}
