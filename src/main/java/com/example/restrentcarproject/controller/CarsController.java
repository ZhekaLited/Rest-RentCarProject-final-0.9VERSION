package com.example.restrentcarproject.controller;

import com.example.restrentcarproject.model.Cars;
import com.example.restrentcarproject.model.Users;
import com.example.restrentcarproject.service.CarsServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CarsController {

    @Autowired
    CarsServiceImpl carsService;

    @GetMapping("/cars/allCars")
    List<Cars> selectAllCars() {
        return carsService.selectAllCars();
    }

    @PostMapping("/cars/add")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean postCreate(@RequestBody Users users) throws SQLException {
        return carsService.createUser(users);
    }

    @GetMapping("/cars/allUsers")
    List<Users> selectAllUsers() {
        return carsService.selectAllUsers();
    }

    @GetMapping("/cars/carsById")
    Cars selectCarById(Long id) {
        return carsService.selectCarById(id);
    }

    @DeleteMapping("/cars/remove")
    public boolean deleteUser(Long id) throws SQLException {
        return carsService.deleteUser(id);
    }

    @PutMapping("/cars/damage")
    public boolean updateDamage(@RequestParam("id") Long id) throws SQLException {
        return carsService.updateDamage(id);
    }

    @PutMapping("/cars/damageNull")
    public boolean updateDamageNull(@RequestParam("id") Long id) {
        return carsService.updateDamagenull(id);
    }

    @PutMapping("/cars/Reason")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean updateReason(@RequestParam("id") Long id, @RequestBody String deviations) throws SQLException, JsonProcessingException {
     //Разпарсить с Json в нормальную строку!!!!!
        ObjectMapper mapper = new ObjectMapper();
        Users users = mapper.readValue(deviations, Users.class);
        return carsService.updateReason(id,users.deviations);
    }
}
