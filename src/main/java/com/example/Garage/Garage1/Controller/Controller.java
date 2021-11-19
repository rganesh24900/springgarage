package com.example.Garage.Garage1.Controller;

import com.example.Garage.Garage1.Entities.Vehicle;
import com.example.Garage.Garage1.ServiceImplementation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class Controller {
    Logger log = LoggerFactory.getLogger(Controller.class);
    @Autowired
    Service imp;

    @GetMapping("/vehiclelist")
    public List<Vehicle>getVehicles(Vehicle veh){
        return this.imp.getVehicles();
    }

    @GetMapping("/vehiclelist/{vehId}")
    public Vehicle getVehicle(@PathVariable String vehId){
        return this.imp.getVehicle(Integer.parseInt(vehId));
    }

    @PostMapping("/vehiclelist")
    public Vehicle addVehicle(@RequestBody Vehicle v){
return this.imp.addVehicle(v);
    }

    @PutMapping("/vehiclelist/{vehId}")
    public  Vehicle updateRepairingVehicle(@PathVariable String id) {
        this.imp.updateRepairingVehicle(Integer.parseInt(id));
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            log.warn("An exception occured in thread");
        }
        return this.imp.updateRepairedVehicle(Integer.parseInt(id));
    }
}
