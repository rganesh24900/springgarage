package com.example.Garage.Garage1.ServiceImplementation;

import com.example.Garage.Garage1.Entities.Garages;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GarageService {
    Garages addGarage(Garages garages);

    List<Garages> getGarages();

    ResponseEntity<Garages> deleteGarage(int id);
}
