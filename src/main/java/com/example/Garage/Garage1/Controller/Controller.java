package com.example.Garage.Garage1.Controller;

import com.example.Garage.Garage1.Entities.Garages;
import com.example.Garage.Garage1.Entities.Vehicle;
import com.example.Garage.Garage1.ServiceImplementation.VehicleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class Controller {

    @Autowired
    VehicleServiceImpl imp;





    /*-----------Vehicles Section--------*/


    @GetMapping("/vehiclelist")
    public List<Vehicle> getVehicles() {
        log.info("The vehicles are:{}", this.imp.getVehicles());
        return this.imp.getVehicles();
    }

    @GetMapping("/vehiclelist/{id}")
    public Vehicle getVehicles(@PathVariable String id){
        return this.imp.getVehicle(Integer.parseInt(id));
    }

    @PostMapping(value = "/vehiclelist")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {


        return this.imp.addVehicle(vehicle.getName(), vehicle.getGarages().getId());
    }

    @PutMapping("/vehiclelist/{id}")
    public Vehicle updateRepairingVehicle(@PathVariable String id) {

        return this.imp.updateRepairingVehicle(Integer.parseInt(id));

    }

    @PutMapping("vehiclelist/{id1}/{id2}")
    public List<Vehicle> updateRepairingVehicles(@PathVariable String id1, @PathVariable String id2) {
        return this.imp.updateRepairingVehicles(Integer.parseInt(id1), Integer.parseInt(id2));
    }

    @DeleteMapping("vehiclelist/{id}")
    public ResponseEntity<Vehicle> deleteVehicle(@PathVariable int id){
        return this.imp.deleteVehicle(id);
    }


    /*---------Garage Section---------*/
    @PostMapping("/garagelist")
    public Garages addGarage(@RequestBody Garages garages) {
        return this.imp.addGarage(garages);
    }

    @GetMapping("/garagelist")
    public List<Garages> getGarages() {
        return this.imp.getGarages();
    }

    @DeleteMapping("/garagelist/{id}")
    ResponseEntity<Garages> deleteGarage(@PathVariable String id){
        return this.imp.deleteGarage(Integer.parseInt(id));
    }


    /*--------Accounts Section------------*/
    @GetMapping("/vehiclelist/accountbalance")
    public String repairedVehicles() {
        return ("The account balance is :" + imp.repairedVehicles());
    }

    @GetMapping("vehiclelist/repairedvehiclessummary")
    public String repairedVehiclesSummmary() {
        log.info("Data's of summary in map {}", imp.repairedVehiclesSummary());
        return ("Cars = " + imp.repairedVehiclesSummary().get("Cars") + " : cost = " + imp.repairedVehiclesSummary().get("Car's Cost") + ", Bikes = " + imp.repairedVehiclesSummary().get("Bikes") + " : cost = " + imp.repairedVehiclesSummary().get("Bike's Cost"));
    }
}
