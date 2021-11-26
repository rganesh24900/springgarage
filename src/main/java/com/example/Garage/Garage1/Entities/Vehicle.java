package com.example.Garage.Garage1.Entities;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@Component
@Entity
@Data
@RequiredArgsConstructor
@Table(name = "vehicle")
public class Vehicle {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private int price;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "garage_id",nullable = false,referencedColumnName = "id")
    private Garages garages;



}
