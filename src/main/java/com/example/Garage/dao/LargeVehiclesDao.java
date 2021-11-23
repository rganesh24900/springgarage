package com.example.Garage.dao;

import com.example.Garage.Garage2.Entities.LargeVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LargeVehiclesDao extends JpaRepository<LargeVehicle,Integer> {

    @Query(value = "select sum(price) from garage.vehicle where status ='Repaired'",nativeQuery = true)
    float repairedVehicles();
    @Query(value = "select sum(price) from garage.vehicle where name='Truck'&& status='Repaired'",nativeQuery = true)
    float repairedTrucksPrice();

    @Query(value = "select count(price) from garage.vehicle where name='Truck'&& status='Repaired'",nativeQuery = true)
    float numberOfTrucks();

    @Query(value = "select sum(price) from garage.vehicle where name='Bus'&& status='Repaired'",nativeQuery = true)
    float repairedBusesPrice();

    @Query(value = "select count(price) from garage.vehicle where name='Bus'&& status='Repaired'",nativeQuery = true)
    float numberOfBuses();
}
