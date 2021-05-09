package com.fpt.vn.model.entitys;

import com.fpt.vn.model.AppUser;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "apply")
@Data
public class ApplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "postId")
    private PostEntity postEntity;

    @ManyToOne
    @JoinColumn(name = "userId")
    private AppUser appUser;

    @Column(nullable = false)
    private int status;

    @Column(nullable = false)
    private Date date;
}
