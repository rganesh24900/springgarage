package com.example.Garage.Garage1.Controller;

import com.example.Garage.Garage1.Entities.Vehicle;
import com.example.Garage.Garage1.ServiceImplementation.Service;
import com.example.Garage.dao.VehiclesDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/vehiclelist/accountbalance")
    public float repairedVehicles(){
       return imp.repairedVehicles();
    }
}
