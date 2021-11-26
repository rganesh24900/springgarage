package com.example.Garage.Garage1.ServiceImplementation;

import com.example.Garage.Garage1.Entities.Garages;
import com.example.Garage.Garage1.Entities.Vehicle;
import org.springframework.http.ResponseEntity;


import java.util.HashMap;
import java.util.List;

public interface VehicleService {

    List<Vehicle> getVehicles();

    Vehicle getVehicle(int id);

    Vehicle addVehicle(String name,int gid);

    Vehicle updateRepairingVehicle(int id);

    List<Vehicle> updateRepairingVehicles(int id1, int id2);

    ResponseEntity<Vehicle>deleteVehicle(int id);

    public float repairedVehicles();

    HashMap<String, Float> repairedVehiclesSummary();






}
