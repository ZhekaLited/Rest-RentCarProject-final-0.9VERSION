package com.example.restrentcarproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageCars {
    @Id
    public Long id;
    public String carsimage;

    public Long carid;
}
