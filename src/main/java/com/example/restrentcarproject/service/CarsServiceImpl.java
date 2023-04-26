package com.example.restrentcarproject.service;

import com.example.restrentcarproject.model.Admin;
import com.example.restrentcarproject.model.Cars;
import com.example.restrentcarproject.model.ImageCars;
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
    public boolean updateReason(Long id,String deviations,boolean disbalance) {
        return carsDao.updateReason(id,deviations,disbalance);
    }

    @Override
    public boolean updateBalance(Long id, Long balance,boolean disbalance) {
        return carsDao.updateBalance(id,balance,disbalance);
    }

    @Override
    public ImageCars[] selectCarImages(Long id) {
        return carsDao.selectCarImages(id);
    }

    @Override
    public boolean insertAccount(String login,String password) {
        return carsDao.insertAccount(login,password);
    }

    @Override
    public boolean insertAdmin(String login, String password) {
        return carsDao.insertAdmin(login,password);
    }

    @Override
    public Admin getRoleName(Long id) {
        return carsDao.getRoleName(id);
    }

    @Override
    public List<Admin> findForLogin(String login,String password) {
        return carsDao.findForLogin(login,password);
    }

    @Override
    public Admin invalid(String body) {
        return carsDao.invalid(body);
    }

    @Override
    public Users selectUsersId(Long id) {
        return carsDao.selectUsersId(id);
    }

    @Override
    public Users getUser(Long userid) {
        return carsDao.getUser(userid);
    }
}
