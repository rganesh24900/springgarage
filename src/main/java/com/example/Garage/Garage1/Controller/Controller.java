package com.example.Garage.Garage1.Controller;

import com.example.Garage.Garage1.Entities.Vehicle;
import com.example.Garage.Garage1.ServiceImplementation.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class Controller {
    //    Logger log = LoggerFactory.getLogger(Controller.class);
    @Autowired
    ServiceImpl imp;



    @GetMapping("/vehiclelist/Garage1")
    public List<Vehicle> getVehicles(Vehicle veh){
    log.info("The vehicles are:{}",this.imp.getVehicles());
    return this.imp.getVehicles();
    }



    @PostMapping(value = "/vehiclelist/Garage1")
    public Vehicle addVehicle( @RequestBody Vehicle vehicle) {


        return this.imp.addVehicle(vehicle);
    }

    @PutMapping("/vehiclelist/Garage1/{id}")
    public Vehicle updateRepairingVehicle(@PathVariable String id) {

        return this.imp.updateRepairingVehicle(Integer.parseInt(id));

    }

    @PutMapping("vehiclelist/Garage1/{id1}/{id2}")
    public List<Vehicle> updateRepairingVehicles(@PathVariable String id1,@PathVariable String id2){
        return this.imp.updateRepairingVehicles(Integer.parseInt(id1),Integer.parseInt(id2));
    }

    @GetMapping("/vehiclelist/Garage1/accountbalance")
    public String repairedVehicles(){
       return ("The account balance is :"+imp.repairedVehicles());
    }

    @GetMapping("vehiclelist/Garage1/repairedvehiclessummary")
    public String repairedVehiclesSummmary(){
        log.info("Data's of summary in map {}",imp.repairedVehiclesSummary());
        return ("Cars = "+imp.repairedVehiclesSummary().get("Cars")+" : cost = "+imp.repairedVehiclesSummary().get("Car's Cost")+", Bikes = "+imp.repairedVehiclesSummary().get("Bikes")+" : cost = "+imp.repairedVehiclesSummary().get("Bike's Cost"));
    }
}
