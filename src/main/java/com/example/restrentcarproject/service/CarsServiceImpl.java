package com.example.restrentcarproject.service;

import com.example.restrentcarproject.model.Admin;
import com.example.restrentcarproject.model.Cars;
import com.example.restrentcarproject.model.ImageCars;
import com.example.restrentcarproject.model.Users;
import com.example.restrentcarproject.repository.CarsDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public boolean deleteCars(Long id) throws SQLException {
        return carsDao.deleteCars(id);
    }

    @Override
    public Cars selectImage(Long id) {
        return carsDao.selectImage(id);
    }

    @Override
    public boolean deleteImageCars(Long id) {
        return carsDao.deleteImageCars(id);
    }

    @Override
    public List<Users> selectAllUsers(Long rowNumber,Long pageSize,String desc) {
        return carsDao.selectAllUsers(rowNumber,pageSize,desc);
    }

    @Override
    public Long countUsers() {
        return carsDao.countUsers();
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
    public void updateDamage(Long id) throws SQLException {
         carsDao.updateDamage(id);
    }

    @Override
    public void updateDamagenull(Long id) {
         carsDao.updateDamagenull(id);
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
    public Long insertCar(Cars cars) {
        return carsDao.insertCar(cars);
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
    public List<Users> getUser(Long userid) {
        return carsDao.getUser(userid);
    }

    @Override
    public boolean insertImageCars(String carsimage, Long carid) {
        return carsDao.insertImageCars(carsimage,carid);
    }

    @Override
    public List<Cars> selectAllCarsSort() {
        return carsDao.selectAllCarsSort();
    }

    @Override
    public boolean updateDamageCarsNull(Long id,boolean status) {
        return carsDao.updateDamageCarsNull(id,status);
    }

    @Override
    public boolean updateDamageCars(Long id,boolean status) {
        return carsDao.updateDamageCars(id,status);
    }

    @Override
    public ImageCars[] selectImages(Long id) {
        return carsDao.selectImages(id);
    }

    @Override
    public Users getIdForUser(Long id) {
        return carsDao.getIdForUser(id);
    }
}
