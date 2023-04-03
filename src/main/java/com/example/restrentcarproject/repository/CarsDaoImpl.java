package com.example.restrentcarproject.repository;

import com.example.restrentcarproject.mapper.CarsMapper;
import com.example.restrentcarproject.model.Admin;
import com.example.restrentcarproject.model.Cars;
import com.example.restrentcarproject.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class CarsDaoImpl implements CarsDAO {

    @Autowired
    CarsMapper carsMapper;

    @Override
    public List<Cars> selectAllCars() {
        return carsMapper.selectAllCars();
    }

    @Override
    public boolean createUser(Users users) throws SQLException {
        return carsMapper.insertUser(users);

    }

    @Override
    public List<Users> selectAllUsers() {
        return carsMapper.selectAllUsers();
    }

    @Override
    public Cars selectCarById(Long id) {
        return carsMapper.selectCarById(id);
    }

    @Override
    public Admin findByUserAuth(String username) throws ClassNotFoundException {
        return carsMapper.getAllLogin(username);

    }

    @Override
    public boolean deleteUser(Long id) throws SQLException {
        return carsMapper.deleteUser(id);
    }

    @Override
    public boolean updateDamage(Long id) throws SQLException {
        return carsMapper.updateDamage(id);
    }

    @Override
    public boolean updateDamagenull(Long id) {
        return carsMapper.updateDamagenull(id);
    }

    @Override
    public boolean updateReason(Long id,String deviations) {
        return carsMapper.updateReason(id,deviations);
    }
}
