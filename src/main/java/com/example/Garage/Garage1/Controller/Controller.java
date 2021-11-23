package com.example.Garage.Garage1.Controller;

import com.example.Garage.Garage1.Entities.Vehicle;
import com.example.Garage.Garage1.ServiceImplementation.Service;
import com.example.Garage.dao.VehiclesDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class Controller {
    //    Logger log = LoggerFactory.getLogger(Controller.class);
    @Autowired
    Service imp;



    @GetMapping("/vehiclelist")
    public List<Vehicle> getVehicles(Vehicle veh) {
        return this.imp.getVehicles();
    }

    @GetMapping("/vehiclelist/{vehId}")
    public Vehicle getVehicle(@PathVariable String vehId) {
        return this.imp.getVehicle(Integer.parseInt(vehId));
    }

    @PostMapping(value = "/vehiclelist")
    public Vehicle addVehicle( @RequestBody Vehicle vehicle) {


        return this.imp.addVehicle(vehicle);
    }

    @PutMapping("/vehiclelist/{id}")
    public Vehicle updateRepairingVehicle(@PathVariable String id) {

        return this.imp.updateRepairingVehicle(Integer.parseInt(id));

    }

    @PutMapping("vehiclelist/{id1}/id2}")
    public List<Vehicle> updateRepairingVehicles(@PathVariable String id1,@PathVariable String id2){
        return this.imp.updateRepairingVehicles(Integer.parseInt(id1),Integer.parseInt(id2));
    }

    @GetMapping("/vehiclelist/accountbalance")
    public String repairedVehicles(){
       return ("The account balance is :"+imp.repairedVehicles());
    }

    @GetMapping("vehiclelist/repairedvehiclessummary")
    public String repairedVehiclesSummmary(){
        return ("Cars = "+imp.repairedVehiclesSummary().get("Cars")+" : cost = "+imp.repairedVehiclesSummary().get("Car's Cost")+", Bikes = "+imp.repairedVehiclesSummary().get("Bikes")+" : cost = "+imp.repairedVehiclesSummary().get("Bike's Cost"));
    }
}
