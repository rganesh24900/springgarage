package com.example.Garage.Garage1.Entities;

import jdk.jfr.DataAmount;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@RequiredArgsConstructor
public class Vehicle {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int price;
    @Column
    private String status;

}
