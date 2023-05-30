package com.example.restrentcarproject.controller;

import com.example.restrentcarproject.imageStorage.FileStorageService;
import com.example.restrentcarproject.model.Admin;
import com.example.restrentcarproject.model.Cars;
import com.example.restrentcarproject.model.ImageCars;
import com.example.restrentcarproject.model.Users;
import com.example.restrentcarproject.service.CarsServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CarsController {

    @Autowired
    CarsServiceImpl carsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/cars/allCars")
    List<Cars> selectAllCars() {
        return carsService.selectAllCars();
    }

    @GetMapping("/cars/allCarsSort")
    List<Cars> selectAllCarsSort() {
        return carsService.selectAllCarsSort();
    }

    @PostMapping("/cars/add")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean postCreate(@RequestBody Users users) throws SQLException {
        return carsService.createUser(users);
    }

    @GetMapping("/cars/allUsers")
    List<Users> selectAllUsers(Long rowNumber, Long pageSize,String desc) {
        List<Users> usersList = carsService.selectAllUsers(rowNumber, pageSize,desc);
        return usersList;
    }

    @GetMapping("/cars/countUsers")
    Long countUsers() {
        Long countUsersList = carsService.countUsers();
        return countUsersList;
    }

    @GetMapping("/cars/carsById")
    Cars selectCarById(Long id) {
        return carsService.selectCarById(id);
    }

    @DeleteMapping("/cars/remove")
    public boolean deleteUser(Long id) throws SQLException {
        if (id != null) {
            carsService.deleteImageCars(id);
            carsService.deleteCars(id);
        } else {
            System.out.println("Id not Found");
        }
        return true;
    }

    @GetMapping("/cars/getImage")
    public boolean getImageCars(Long id) {
        if (id != null) {
            Cars image = carsService.selectImage(id);
            String stringImageName = image.image;
            File file = new File("D:/PhotosProject/" + stringImageName); //Удаление файлов из папок.По назначеному пути!!!
            if (file.delete()) {
                System.out.println("D:/PhotosProject/" + stringImageName + " " + "File Delete");
            } else System.out.println("D:/PhotosProject/" + stringImageName + " " + "File Not Found");
        }
        return true;
    }

    @GetMapping("/cars/getImages")
    public boolean getImagesCars(Long id) {
        ImageCars[] stringImageName = carsService.selectImages(id);
        for (ImageCars car : stringImageName) {
            String image = car.carsimage;
            String path = "D:/PhotosProject/";

            File file = new File(path + image); //Удаление файлов из папок.По назначеному пути!!!
            if (file.exists()) {
                if (file.delete()) {
                    System.out.println(path + image + " " + "File Delete");
                }
            } else {
                System.out.println(path + image + " " + "File Not Found");
            }
        }
        return true;
    }

    @PutMapping("/cars/damage")
    public String updateDamage(@RequestParam("id") Long id) throws SQLException {
        carsService.updateDamage(id);
        return "{\"image\":\"damage.png\"}";
    }

    @PutMapping("/cars/damageCars")
    public boolean updateDamageCars(@RequestParam("id") Long id, @RequestBody String jsonString) throws SQLException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonString);
        Boolean status = jsonNode.path("param").path("status").asBoolean();
        return carsService.updateDamageCars(id, status);
    }

    @PutMapping("/cars/damageCarsNull")
    public boolean updateDamageCarsNull(@RequestParam("id") Long id, @RequestBody String jsonString) throws SQLException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonString);
        Boolean status = jsonNode.path("param").path("status").asBoolean();
        return carsService.updateDamageCarsNull(id, status);
    }

    @PutMapping("/cars/damageNull")
    public String updateDamageNull(@RequestParam("id") Long id) {
        carsService.updateDamagenull(id);
        return  "{\"image\":\"\"}";
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
        return carsService.updateReason(id, users.deviations, disbalance);
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
                ? carsService.updateBalance(id, balance - price, disbalance)
                : false;

        return isOk
                ? balance - price
                : 0;
    }

    // ? Это if // : Это else
    @GetMapping("/cars/images")
    List<String> selectCarImages(@RequestParam("id") Long id) {
        ImageCars[] cars = carsService.selectCarImages(id);
        List<String> result = new ArrayList<String>();

        for (ImageCars car : cars) {
            result.add(car.carsimage);
        }
        return result;
    }

    @PostMapping("/cars/addAcount")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean insertAccount(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(body);
        String login = jsonNode.path("login").asText();
        String password = jsonNode.path("password").asText();
        String encode = passwordEncoder.encode(password);
        return carsService.insertAccount(login, encode);
    }

    @PostMapping("/cars/addAdmin")
    public boolean insertAdmin(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(body);
        String login = jsonNode.path("login").asText();
        String password = jsonNode.path("password").asText();
        String encode = passwordEncoder.encode(password);
        return carsService.insertAdmin(login, encode);
    }

    @GetMapping("/cars/getRole")
    public String getRoleName(@RequestParam("id") Long id) throws JsonProcessingException {
        Admin admin = carsService.getRoleName(id);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(admin);
        return json;
    }

    @PostMapping("/cars/getUser")
    public String findForLogin(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(body);
        String login = jsonNode.path("login").asText();
        String password = jsonNode.path("password").asText();

        List<Admin> admin = carsService.findForLogin(login, password);

        Admin findAdmin = null;
        for (Admin admin1 : admin) {
            String p1 = password;
            String p2 = admin1.password;
            boolean result = passwordEncoder.matches(p1, p2); //Для сравнения обычного пароля и хэш пароля!!!
            if (result) {
                findAdmin = admin1;
                break;
            }
        }

        if (findAdmin != null) {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(findAdmin);
            return json;
        }
        return null;
    }

    @GetMapping("/cars/valid")
    public Admin selectUsersId(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(body);
        String login = jsonNode.path("login").asText();
        return carsService.invalid(login);
    }

    @GetMapping("/cars/getIdUser")
    public List<Users> getUser(Long userid) {
        return carsService.getUser(userid);
    }

    @PostMapping("/cars/addCar")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean postCreateCar(@RequestBody Cars cars) throws SQLException {
        carsService.insertCar(cars);
        Long id = cars.id;
        for (String carsImage : cars.carsimage) {
            String image = carsImage;
            carsService.insertImageCars(image, id);
        }
        return true;
    }

    @GetMapping("/cars/userById")
    Users getIdForUser(Long id) {
        return carsService.getIdForUser(id);
    }
}