package com.example.restrentcarproject.repository;

import com.example.restrentcarproject.model.Admin;
import com.example.restrentcarproject.model.Cars;
import com.example.restrentcarproject.model.ImageCars;
import com.example.restrentcarproject.model.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface  CarsDAO {

    List<Cars> selectAllCars();

    boolean createUser(Users users) throws SQLException;

    List<Users> selectAllUsers(Long rowNumber,Long pageSize,String desc);

    Long countUsers();

    Cars selectCarById(Long id);

    Admin findByUserAuth(String username) throws ClassNotFoundException;

    boolean deleteCars(Long id) throws SQLException;

    boolean deleteImageCars(Long id);

    void updateDamage(Long id) throws SQLException;

    void updateDamagenull(Long id);

    boolean updateReason(Long id, String deviations, boolean disbalance);

    boolean updateBalance(Long id, Long balance, boolean disbalance);

    ImageCars[] selectCarImages(Long id);

    boolean insertAccount(String login, String password);

    boolean insertAdmin(String login, String password);

    Admin getRoleName(Long id);

    List<Admin> findForLogin(String login, String password);

    Users selectUsersId(@Param("id") Long id);

    Admin invalid(String body);

    List<Users> getUser(Long userid);

    Long insertCar(Cars cars);

    boolean insertImageCars(String carsimage, Long carid);

    boolean updateDamageCars(Long id, boolean status);

    boolean updateDamageCarsNull(Long id, boolean status);

    List<Cars> selectAllCarsSort();

    Cars selectImage(Long id);
    ImageCars[] selectImages(Long id);
    Users getIdForUser (Long id);
}