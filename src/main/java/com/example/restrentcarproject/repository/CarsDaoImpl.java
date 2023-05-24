package com.example.restrentcarproject.repository;

import com.example.restrentcarproject.mapper.CarsMapper;
import com.example.restrentcarproject.model.Admin;
import com.example.restrentcarproject.model.Cars;
import com.example.restrentcarproject.model.ImageCars;
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
    public boolean deleteCars(Long id) throws SQLException {
        return carsMapper.deleteCars(id);
    }

    @Override
    public boolean deleteImageCars(Long id) {
        return carsMapper.deleteImageCars(id);
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
    public boolean updateReason(Long id,String deviations,boolean disbalance) {
        return carsMapper.updateReason(id,deviations,disbalance);
    }

    @Override
    public boolean updateBalance(Long id, Long balance,boolean disbalance) {
        return carsMapper.updateBalance(id,balance,disbalance);
    }

    @Override
    public ImageCars[] selectCarImages(Long id) {
        return carsMapper.selectCarImages(id);
    }

    @Override
    public boolean insertAccount(String login,String password) {
        return carsMapper.insertAccount(login,password);
    }

    @Override
    public boolean insertAdmin(String login, String password) {
        return carsMapper.insertAdmin(login,password);
    }

    @Override
    public Admin getRoleName(Long id) {
        return carsMapper.getRoleName(id);
    }

    @Override
    public List<Admin> findForLogin(String login,String password) {
        return carsMapper.findForLogin(login,password);
    }

    @Override
    public Users selectUsersId(Long id) {
        return carsMapper.selectUsersId(id);
    }

    @Override
    public Admin invalid(String body) {
        return carsMapper.invalid(body);
    }

    @Override
    public  List<Users> getUser(Long userid) {
        return carsMapper.getUser(userid);
    }

    @Override
    public Long insertCar(Cars cars) {
        return carsMapper.insertCar(cars);
    }

    @Override
    public boolean insertImageCars(String carsimage, Long carid) {
        return carsMapper.insertImageCars(carsimage,carid);
    }

    @Override
    public boolean updateDamageCars(Long id,boolean status) {
        return carsMapper.updateDamageCars(id,status);
    }

    @Override
    public boolean updateDamageCarsNull(Long id,boolean status) {
        return carsMapper.updateDamageCarsNull(id,status);
    }

    @Override
    public List<Cars> selectAllCarsSort() {
        return carsMapper.selectAllCarsSort();
    }

    @Override
    public Cars selectImage(Long id) {
        return carsMapper.selectImage(id);
    }

    @Override
    public ImageCars[] selectImages(Long id) {
        return carsMapper.selectImages(id);
    }

    @Override
    public Users getIdForUser(Long id) {
        return carsMapper.getIdForUser(id);
    }
}
