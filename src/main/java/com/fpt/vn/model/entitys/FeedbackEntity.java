package com.fpt.vn.model.entitys;

import com.fpt.vn.model.AppUser;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "feedback")
public class FeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idDoctor;
    private int counts;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;
}
