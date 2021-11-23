package com.example.Garage.Garage2.ServiceImplementation;


import com.example.Garage.Garage1.Entities.Vehicle;
import com.example.Garage.Garage2.Entities.LargeVehicle;
import com.example.Garage.dao.LargeVehiclesDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class LargeServiceImpl implements LargeService {
    @Autowired
    private LargeVehiclesDao daO;
    @Autowired
    LargeVehicle vehicle;


    public List<LargeVehicle> getVehicles() {


        return daO.findAll();

    }




    public LargeVehicle addVehicle(LargeVehicle vehicle) {

        LargeVehicle vehicle1 = new LargeVehicle();

        for (int i = 0; i <= 10; i++) {


            if (vehicle.getName().equals("Truck")) {


                vehicle1.setName("Truck");
                vehicle1.setPrice(810);
                vehicle1.setStatus("In Garage");
            } else if (vehicle.getName().equals("Bus")) {
                vehicle1.setName("Bus");
                vehicle1.setPrice(800);
                vehicle1.setStatus("In Garage");
            }


            daO.save(vehicle1);
            i++;
        }
        return vehicle1;


    }


    public LargeVehicle updateRepairingVehicle(int id) {


        LargeVehicle vv = daO.getById(id);
        this.vehicle.setId(id);
        this.vehicle.setStatus("Repairing");
        this.vehicle.setName(vv.getName());
        this.vehicle.setPrice(vv.getPrice());
        daO.save(this.vehicle);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            log.warn("An error occured %s", e);
        }

        this.vehicle.setStatus("Repaired");
        daO.save(this.vehicle);

        return this.vehicle;

    }

    public List<LargeVehicle> updateRepairingVehicles(int id1, int id2) {


        LargeVehicle vehicle1 = new LargeVehicle();
        LargeVehicle vehicle2 = new LargeVehicle();
        LargeVehicle veh1 = daO.getById(id1); //First vehicle

        vehicle1.setId(veh1.getId());
        vehicle1.setStatus("Repairing");

        vehicle1.setName(veh1.getName());
        vehicle1.setPrice(veh1.getPrice());
        daO.save(vehicle1);
        LargeVehicle veh2 = daO.getById(id2);
        vehicle2.setId(id2);
        vehicle2.setStatus("Repairing");
        vehicle2.setName(veh2.getName());
        vehicle2.setPrice(veh2.getPrice());
        daO.save(vehicle2);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            log.info("An error occured %s", e);
        }

        vehicle1.setStatus("Repaired");
        daO.save(vehicle1);

        // Putting another Vehicle in a Garage


        vehicle2.setStatus("Repaired");

        daO.save(vehicle2);

        List<LargeVehicle> list = new ArrayList<>();
        list.add(vehicle1);
        list.add(vehicle2);
        return list;
    }

    public float repairedVehicles() {
        return daO.repairedVehicles();
    }

    public HashMap<String, Float> repairedVehiclesSummary() {
        HashMap<String, Float> hashMap = new HashMap<>();
        hashMap.put("Trucks", daO.numberOfTrucks());
        hashMap.put("Buses", daO.numberOfBuses());
        hashMap.put("Truck's Cost", daO.repairedTrucksPrice());
        hashMap.put("Buses Cost", daO.repairedBusesPrice());

        return hashMap;
    }
}
