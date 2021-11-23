package com.example.Garage.Garage2.ServiceImplementation;

import com.example.Garage.Garage1.Entities.Vehicle;
import com.example.Garage.Garage2.Entities.LargeVehicle;

import java.util.HashMap;
import java.util.List;

public interface LargeService {

     List<LargeVehicle> getVehicles();

    LargeVehicle addVehicle(LargeVehicle vehicle);

    LargeVehicle updateRepairingVehicle(int id);

    List<LargeVehicle> updateRepairingVehicles(int id1, int id2);

    float repairedVehicles();

    HashMap<String, Float> repairedVehiclesSummary();
}
