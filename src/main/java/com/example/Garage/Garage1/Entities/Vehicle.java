package com.example.Garage.Garage1.Entities;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Component
@Entity
@Data
@RequiredArgsConstructor
public class Vehicle {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private int price;

    @Column
    private String status;

}
