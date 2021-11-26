package com.example.Garage.Garage1.ServiceImplementation;

import com.example.Garage.Garage1.Entities.Garages;
import com.example.Garage.Garage1.Entities.Vehicle;
import com.example.Garage.dao.GarageDao;
import com.example.Garage.dao.VehiclesDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Slf4j
@org.springframework.stereotype.Service
public class VehicleServiceImpl implements VehicleService, GarageService {
    @Autowired
    private VehiclesDao dao;

    @Autowired
    private GarageDao gdao;


    List<Vehicle> list = new ArrayList<>();


    public List<Vehicle> getVehicles() {


        return dao.findAll();

    }

    public Vehicle getVehicle(int id) {
        return dao.getById(id);
    }

    public Vehicle addVehicle(String name, int gid) {


        Vehicle vehicle1 = new Vehicle();

        if (name.equals("Car")) {


            vehicle1.setName("Car");
            vehicle1.setPrice(500);
            vehicle1.setStatus("In Garage");
            vehicle1.setGarages(gdao.getById(gid));


        } else if (name.equals("Bike")) {
            vehicle1.setName("Bike");
            vehicle1.setPrice(200);
            vehicle1.setStatus("In Garage");
            vehicle1.setGarages(gdao.getById(gid));


        }
        list.add(vehicle1);
        dao.save(vehicle1);

        return vehicle1;


    }


    public Vehicle updateRepairingVehicle(int id) {
        Vehicle vehicle = new Vehicle();
        Vehicle vv = dao.getById(id);
        vehicle.setId(id);
        vehicle.setStatus("Repairing");
        vehicle.setName(vv.getName());
        vehicle.setPrice(vv.getPrice());
        vehicle.setGarages(vv.getGarages());


        dao.save(vehicle);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            log.warn("An error occured %s", e);
        }

        vehicle.setStatus("Repaired");
        dao.save(vehicle);

        return vehicle;

    }

    public List<Vehicle> updateRepairingVehicles(int id1, int id2) {


        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        Vehicle veh1 = dao.getById(id1);

        vehicle1.setId(veh1.getId());
        vehicle1.setStatus("Repairing");

        vehicle1.setName(veh1.getName());
        vehicle1.setPrice(veh1.getPrice());
        vehicle1.setGarages(veh1.getGarages());
        dao.save(vehicle1);
        Vehicle veh2 = dao.getById(id2);
        vehicle2.setId(id2);
        vehicle2.setStatus("Repairing");
        vehicle2.setName(veh2.getName());
        vehicle2.setPrice(veh2.getPrice());
        vehicle2.setGarages(veh2.getGarages());
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

    @Override
    public ResponseEntity<Vehicle> deleteVehicle(int id) {
        try {


            Vehicle v = dao.getById(id);
            dao.delete(v);

            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
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

    public Garages addGarage(Garages garage) {
        Garages garage1 = new Garages();

        try {


            garage1.setName(garage.getName());
            garage1.setVehicle(this.list);
            gdao.save(garage1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return garage1;

    }

    public List<Garages> getGarages() {
        return gdao.findAll();
    }

    public ResponseEntity<Garages> deleteGarage(int id) {
        try {


            Garages g = gdao.getById(id);
            gdao.delete(g);

            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}