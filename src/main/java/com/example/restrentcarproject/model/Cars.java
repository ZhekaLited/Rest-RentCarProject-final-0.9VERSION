package com.example.restrentcarproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cars {

    @Id
    public Long id;
    public Long price;
    public String name;
    public String model;
    public String image;
    public String release;
    public String kpp;
    public String dvigatel;
    public String mesta;
    public String[] carsimage;
    public String damage;
    public boolean status;
}
