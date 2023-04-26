package com.example.restrentcarproject.repository;

import com.example.restrentcarproject.model.Admin;
import com.example.restrentcarproject.model.Cars;
import com.example.restrentcarproject.model.ImageCars;
import com.example.restrentcarproject.model.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface  CarsDAO {

    List<Cars> selectAllCars();
    boolean createUser(Users users) throws SQLException;
    List<Users> selectAllUsers();
    Cars selectCarById (Long id);
    Admin findByUserAuth(String username) throws ClassNotFoundException;
    boolean deleteUser(Long id) throws SQLException;
    boolean updateDamage(Long id) throws SQLException;
    boolean updateDamagenull(Long id);
    boolean updateReason(Long id,String deviations,boolean disbalance);
    boolean updateBalance(Long id,Long balance,boolean disbalance);
    ImageCars[] selectCarImages(Long id);
    boolean insertAccount(String login,String password);
    boolean insertAdmin(String login,String password);
    Admin getRoleName(Long id);
    List<Admin> findForLogin(String login,String password);
    Users selectUsersId(@Param("id") Long id);
    Admin invalid(String body);

    Users getUser(Long userid);



}
