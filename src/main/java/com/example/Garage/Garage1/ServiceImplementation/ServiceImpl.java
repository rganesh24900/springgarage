package com.example.Garage.Garage1.ServiceImplementation;

import com.example.Garage.Garage1.Entities.Vehicle;
import com.example.Garage.dao.VehiclesDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Slf4j
@org.springframework.stereotype.Service
public class ServiceImpl implements Service{
    @Autowired
    private VehiclesDao dao;
    @Autowired
    Vehicle vehicle;


    public List<Vehicle> getVehicles() {


        return dao.findAll();

    }


    public Vehicle addVehicle(Vehicle vehicle) {

        Vehicle vehicle1 = new Vehicle();

        for (int i = 0; i <= 10; i++) {


            if (vehicle.getName().equals("Car")) {


                vehicle1.setName("Car");
                vehicle1.setPrice(500);
                vehicle1.setStatus("In Garage");
            } else if (vehicle.getName().equals("Bike")) {
                vehicle1.setName("Bike");
                vehicle1.setPrice(200);
                vehicle1.setStatus("In Garage");
            }


            dao.save(vehicle1);
            i++;
        }
        return vehicle1;


    }


    public Vehicle updateRepairingVehicle(int id) {


        Vehicle vv = dao.getById(id);
        this.vehicle.setId(id);
        this.vehicle.setStatus("Repairing");
        this.vehicle.setName(vv.getName());
        this.vehicle.setPrice(vv.getPrice());
        dao.save(this.vehicle);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            log.warn("An error occured %s", e);
        }

        this.vehicle.setStatus("Repaired");
        dao.save(this.vehicle);

        return this.vehicle;

    }

    public List<Vehicle> updateRepairingVehicles(int id1, int id2) {


        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        Vehicle veh1 = dao.getById(id1); //First vehicle

        vehicle1.setId(veh1.getId());
        vehicle1.setStatus("Repairing");

        vehicle1.setName(veh1.getName());
        vehicle1.setPrice(veh1.getPrice());
        dao.save(vehicle1);
        Vehicle veh2 = dao.getById(id2);
        vehicle2.setId(id2);
        vehicle2.setStatus("Repairing");
        vehicle2.setName(veh2.getName());
        vehicle2.setPrice(veh2.getPrice());
        dao.save(vehicle2);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            log.info("An error occured %s", e);
        }

        vehicle1.setStatus("Repaired");
        dao.save(vehicle1);

        // Putting another Vehicle in a Garage


        vehicle2.setStatus("Repaired");

        dao.save(vehicle2);

        List<Vehicle> list = new ArrayList<>();
        list.add(vehicle1);
        list.add(vehicle2);
        return list;
    }

    public float repairedVehicles() {
        return dao.repairedVehicles();
    }

    public HashMap<String, Float> repairedVehiclesSummary() {
        HashMap<String, Float> hashMap = new HashMap<>();
        hashMap.put("Cars", dao.numberOfCars());
        hashMap.put("Bikes", dao.numberOfBikes());
        hashMap.put("Car's Cost", dao.repairedCarsPrice());
        hashMap.put("Bike's Cost", dao.repairedBikePrice());

        return hashMap;
    }


}