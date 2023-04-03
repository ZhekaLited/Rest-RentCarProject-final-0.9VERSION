package com.example.restrentcarproject.service;

import com.example.restrentcarproject.model.Admin;
import com.example.restrentcarproject.model.Cars;
import com.example.restrentcarproject.model.Users;
import com.example.restrentcarproject.repository.CarsDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {

    @Autowired
    CarsDaoImpl carsDao;

    @Override
    public List<Cars> selectAllCars() {
        return carsDao.selectAllCars();
    }

    @Override
    public boolean createUser(Users users) throws SQLException {
        return carsDao.createUser(users);
    }

    @Override
    public boolean deleteUser(Long id) throws SQLException {
        return carsDao.deleteUser(id);
    }

    @Override
    public List<Users> selectAllUsers() {
        return carsDao.selectAllUsers();
    }

    @Override
    public Cars selectCarById(Long id) {
        return carsDao.selectCarById(id);
    }

    @Override
    public Admin findByUserAuth(String username) throws ClassNotFoundException {
        return carsDao.findByUserAuth(username);
    }

    @Override
    public boolean updateDamage(Long id) throws SQLException {
        return carsDao.updateDamage(id);
    }

    @Override
    public boolean updateDamagenull(Long id) {
        return carsDao.updateDamagenull(id);
    }

    @Override
    public boolean updateReason(Long id,String deviations) {
        return carsDao.updateReason(id,deviations);
    }
}
