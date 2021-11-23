package com.example.Garage.Garage1.ServiceImplementation;

import com.example.Garage.Garage1.Entities.Vehicle;
import com.example.Garage.Garage2.Entities.LargeVehicle;

import java.util.HashMap;
import java.util.List;

public interface Service {

    List<Vehicle> getVehicles();

    Vehicle addVehicle(Vehicle vehicle);

    Vehicle updateRepairingVehicle(int id);

    List<Vehicle> updateRepairingVehicles(int id1, int id2);

    public float repairedVehicles();

    HashMap<String, Float> repairedVehiclesSummary();


}
