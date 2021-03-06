package com.fpt.vn.model.entitys;

import com.fpt.vn.model.AppUser;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "recruitment")
@Data
public class RecruitmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "postId")
    private PostEntity postEntity;

    @OneToOne
    @JoinColumn(name = "applyId")
    private ApplyEntity applyEntity;

    @Column(nullable = false)
    private Date date;
}
