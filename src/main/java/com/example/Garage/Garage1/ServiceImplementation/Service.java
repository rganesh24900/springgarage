package com.example.Garage.Garage1.ServiceImplementation;

import com.example.Garage.Garage1.Entities.Vehicle;
import com.example.Garage.dao.VehiclesDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Slf4j
@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private VehiclesDao dao;
    @Autowired
    Vehicle vehicle;


    public List<Vehicle> getVehicles() {


        return dao.findAll();

    }

    public Vehicle getVehicle(int id) {
        return dao.getById(id);
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
        int i = 0;
        while (i < 2) {
            Vehicle vv = dao.getById(id);
            this.vehicle.setId(id);
            this.vehicle.setStatus("Repairing");
            this.vehicle.setName(vv.getName());
            this.vehicle.setPrice(vv.getPrice());
            dao.save(this.vehicle);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                log.info("An error occured %s", e);
            }

            this.vehicle.setStatus("Repaired");
            dao.save(this.vehicle);
            i++;
        }
        return this.vehicle;

    }

    public float repairedVehicles() {
        return dao.repairedVehicles();
    }




}
