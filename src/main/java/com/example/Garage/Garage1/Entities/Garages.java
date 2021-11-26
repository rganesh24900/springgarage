package com.example.Garage.Garage1.Entities;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Component
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "garage")
public class Garages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull private int id;

    @Column
    @NotNull private String name;

    @OneToMany(mappedBy = "garages")
   private List<Vehicle> vehicle;
}
