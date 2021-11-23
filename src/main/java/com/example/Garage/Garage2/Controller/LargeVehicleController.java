package com.example.Garage.Garage2.Controller;

import com.example.Garage.Garage1.Entities.Vehicle;
import com.example.Garage.Garage2.Entities.LargeVehicle;
import com.example.Garage.Garage2.ServiceImplementation.LargeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class LargeVehicleController {
    @Autowired
    LargeServiceImpl impl;


    @GetMapping("/vehiclelist/Garage2")
    public List<LargeVehicle> getVehicles(Vehicle veh) {
        log.info("The vehicles are:{}", this.impl.getVehicles());
        return this.impl.getVehicles();
    }


    @PostMapping(value = "/vehiclelist/Garage2")
    public LargeVehicle addVehicle(@RequestBody LargeVehicle vehicle) {


        return this.impl.addVehicle(vehicle);
    }

    @PutMapping("/vehiclelist/Garage2/{id}")
    public LargeVehicle updateRepairingVehicle(@PathVariable String id) {

        return this.impl.updateRepairingVehicle(Integer.parseInt(id));

    }

    @PutMapping("vehiclelist/Garage2/{id1}/{id2}")
    public List<LargeVehicle> updateRepairingVehicles(@PathVariable String id1, @PathVariable String id2) {
        return this.impl.updateRepairingVehicles(Integer.parseInt(id1), Integer.parseInt(id2));
    }

    @GetMapping("/vehiclelist/Garage2/accountbalance")
    public String repairedVehicles() {
        return ("The account balance is :" + impl.repairedVehicles());
    }

    @GetMapping("vehiclelist/Garage2/repairedvehiclessummary")
    public String repairedVehiclesSummmary() {
        log.info("Data's of summary in map {}", this.impl.repairedVehiclesSummary());
        return ("Trucks = " + this.impl.repairedVehiclesSummary().get("Trucks") + " : cost = " + this.impl.repairedVehiclesSummary().get("Truck's Cost") + ", Buses = " + this.impl.repairedVehiclesSummary().get("Buses") + " : cost = " + this.impl.repairedVehiclesSummary().get("Buses Cost"));
    }
}
