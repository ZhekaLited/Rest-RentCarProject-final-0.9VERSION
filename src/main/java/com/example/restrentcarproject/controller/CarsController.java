package com.example.restrentcarproject.controller;

import com.example.restrentcarproject.model.Cars;
import com.example.restrentcarproject.model.Users;
import com.example.restrentcarproject.service.CarsServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    public boolean updateReason(@RequestParam("id") Long id, @RequestBody String jsonString) throws SQLException, JsonProcessingException {
//Разпарсить с Json в нормальную строку!!!!!
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonString);
        Boolean disbalance = jsonNode.path("param").path("disbalance").asBoolean(); //Получение значения boolean с кнопки!!!!
        String deviations = jsonNode.path("param").path("deviations").toString();
        Users users = mapper.readValue(deviations, Users.class);
        return carsService.updateReason(id,users.deviations,disbalance);
    }

    @PutMapping("/cars/balance")
    @ResponseStatus(HttpStatus.CREATED)
    public Long updateBalance(@RequestParam("id") Long id, @RequestBody String jsonString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonString);

        Long price = jsonNode.path("param").path("price").asLong();//Достать JSON и преобразовать в Long
        Long balance = jsonNode.path("param").path("balance").asLong();
        Boolean disbalance = jsonNode.path("param").path("disbalance").asBoolean(); //Получение значения boolean с кнопки!!!!

        Boolean isOk = balance >= price
                ? carsService.updateBalance(id, balance - price,disbalance)
                : false;

        return isOk
                ? balance - price
                : 0;
    }
// ? Это if // : Это else

//    @PutMapping("/cars/damageButton")
//    public boolean damageButton(@RequestParam("id") Long id,@RequestBody String jsonString) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode jsonNode = mapper.readTree(jsonString);
//
//        Boolean disbalance = jsonNode.path("param").path("disbalance").asBoolean();
//
//        return ca
//    }
}
