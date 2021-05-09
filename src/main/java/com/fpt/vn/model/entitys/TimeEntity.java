package com.fpt.vn.model.entitys;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "time_book")
public class TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String time;
}
