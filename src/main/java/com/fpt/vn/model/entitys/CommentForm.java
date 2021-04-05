package com.fpt.vn.model.entitys;

import com.fpt.vn.model.AppUser;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class CommentForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    private Date createAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;
}
