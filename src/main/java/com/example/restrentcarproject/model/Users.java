package com.example.restrentcarproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    public Long id;
    public String name;
    public String surname;
    public LocalDate birthday;
    public String passid;
    public Long balance;
    public String timearent;
    public Long carsid;
    public String nameCars;
    public String model;
    public Long price;
    public String damage;
    public String deviations;
}
