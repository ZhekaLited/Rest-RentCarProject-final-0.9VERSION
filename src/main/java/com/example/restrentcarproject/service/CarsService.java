package com.example.restrentcarproject.service;

import com.example.restrentcarproject.model.Admin;
import com.example.restrentcarproject.model.Cars;
import com.example.restrentcarproject.model.ImageCars;
import com.example.restrentcarproject.model.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;

@Service
public interface CarsService {

    List<Cars> selectAllCars();
    boolean createUser(Users users) throws SQLException;
    boolean deleteCars(Long id) throws SQLException;

    Cars selectImage(Long id);
    boolean deleteImageCars(Long id);
    List<Users> selectAllUsers();
    Cars selectCarById(Long id);
    Admin findByUserAuth(String username) throws ClassNotFoundException;
    boolean updateDamage(Long id) throws SQLException;
    boolean updateDamagenull(Long id);
    boolean updateReason(Long id,String deviations,boolean disbalance);
    boolean updateBalance(Long id,Long balance,boolean disbalance);
    ImageCars[] selectCarImages(Long id);
    Long insertCar(Cars cars);

    boolean insertAccount(String login,String password);
    boolean insertAdmin(String login,String password);
    Admin getRoleName(Long id);
    List<Admin> findForLogin(String login,String password);
    Admin invalid(String body);
    Users selectUsersId(@Param("id") Long id);
    Users getUser(Long userid);
    boolean insertImageCars(String carsimage,Long carid);

    List<Cars> selectAllCarsSort();

    boolean updateDamageCarsNull(Long id,boolean status);

    boolean updateDamageCars(Long id,boolean status);

    ImageCars[] selectImages (Long id);

    Admin getIdForLogin (String login);
}
