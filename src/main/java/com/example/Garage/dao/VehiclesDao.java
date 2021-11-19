package com.example.Garage.dao;

import com.example.Garage.Garage1.Entities.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiclesDao extends JpaRepository<Vehicle,Integer> {

}
