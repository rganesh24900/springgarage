package com.example.Garage.dao;

import com.example.Garage.Garage1.Entities.Garages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GarageDao extends JpaRepository<Garages,Integer> {


}
