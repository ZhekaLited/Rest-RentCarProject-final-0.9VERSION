package com.example.restrentcarproject.service;

import com.example.restrentcarproject.model.Admin;
import com.example.restrentcarproject.model.Cars;
import com.example.restrentcarproject.model.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface CarsService {

    List<Cars> selectAllCars();

    boolean createUser(Users users) throws SQLException;

    boolean deleteUser(Long id) throws SQLException;

    List<Users> selectAllUsers();

    Cars selectCarById(Long id);

    Admin findByUserAuth(String username) throws ClassNotFoundException;

    boolean updateDamage(Long id) throws SQLException;

    boolean updateDamagenull(Long id);

    boolean updateReason(Long id,String deviations);
}
