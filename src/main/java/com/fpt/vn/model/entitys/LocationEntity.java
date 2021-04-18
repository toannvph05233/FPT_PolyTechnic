package com.fpt.vn.model.entitys;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "location")
@Data
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;


}
