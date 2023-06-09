package com.example.restrentcarproject.service;

import com.example.restrentcarproject.model.Admin;
import com.example.restrentcarproject.model.Cars;
import com.example.restrentcarproject.model.ImageCars;
import com.example.restrentcarproject.model.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface CarsService {

    List<Cars> selectAllCars();
    boolean createUser(Users users) throws SQLException;
    boolean deleteCars(Long id) throws SQLException;

    Cars selectImage(Long id);
    boolean deleteImageCars(Long id);
    List<Users> selectAllUsers(Long rowNumber,Long pageSize,String desc,String sortField);

    List<Users> selectAllUsersSortCars(Long rowNumber,Long pageSize,String desc,String sortField);
    Long countUsers();
    Cars selectCarById(Long id);
    Admin findByUserAuth(String username) throws ClassNotFoundException;
    void updateDamage(Long id) throws SQLException;
    void updateDamagenull(Long id);
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
    List<Users> getUser(Long userid);
    boolean insertImageCars(String carsimage,Long carid);

    List<Cars> selectAllCarsSort();

    boolean updateDamageCarsNull(Long id,boolean status);

    boolean updateDamageCars(Long id,boolean status);

    ImageCars[] selectImages (Long id);

    Users getIdForUser (Long id);

    Admin findForIdLogin(Long userid);
}
