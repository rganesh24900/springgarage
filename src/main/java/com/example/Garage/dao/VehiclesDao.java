package com.example.Garage.dao;

import com.example.Garage.Garage1.Entities.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehiclesDao extends JpaRepository<Vehicle,Integer> {


    @Query(value = "select sum(price) from garage.vehicle where status ='Repaired'",nativeQuery = true)
     float repairedVehicles();


    @Query(value = "select sum(price) from garage.vehicle where name='Car'&& status='Repaired'",nativeQuery = true)
    float repairedCarsPrice();

    @Query(value = "select count(price) from garage.vehicle where name='Car'&& status='Repaired'",nativeQuery = true)
    float numberOfCars();

    @Query(value = "select sum(price) from garage.vehicle where name='Bike'&& status='Repaired'",nativeQuery = true)
    float repairedBikePrice();

    @Query(value = "select count(price) from garage.vehicle where name='Bike'&& status='Repaired'",nativeQuery = true)
    float numberOfBikes();




}
