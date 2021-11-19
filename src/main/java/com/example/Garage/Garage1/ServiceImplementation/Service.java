package com.example.Garage.Garage1.ServiceImplementation;

import com.example.Garage.Garage1.Entities.Vehicle;
import com.example.Garage.dao.VehiclesDao;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Slf4j
@org.springframework.stereotype.Service
public class Service {
@Autowired
private VehiclesDao dao;

List<Vehicle> list;


public List<Vehicle> getVehicles(){

    return dao.findAll();

}

public Vehicle getVehicle(int id){
    return dao.getById(id);
}

public Vehicle addVehicle(Vehicle v){
     dao.save(v);
return v;
}

public Vehicle updateRepairingVehicle(int id){
    Vehicle vehicle = dao.getById(id);
    vehicle.setStatus("Repairing");
    dao.save(vehicle);

    return vehicle;
}
public Vehicle updateRepairedVehicle(int id){
    Vehicle repairedVehicle = dao.getById(id);
    repairedVehicle.setStatus("Repaired");
    dao.save(repairedVehicle);
    return repairedVehicle;
}


}
