package com.example.restrentcarproject.mapper;

import com.example.restrentcarproject.model.Admin;
import com.example.restrentcarproject.model.Cars;
import com.example.restrentcarproject.model.ImageCars;
import com.example.restrentcarproject.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface CarsMapper {

    List<Cars> selectAllCars();
    List<Cars> selectAllCarsSort();
    boolean insertUser(Users users);
    List<Users> selectAllUsers(Long rowNumber,Long pageSize,String desc,String sortField);
    List<Users> selectAllUsersSortCars(Long rowNumber,Long pageSize,String desc,String sortField);
    Long countUsers();
    boolean deleteCars(@Param("id") Long id);
    Cars selectImage(@Param("id") Long id);
    boolean deleteImageCars(@Param("id") Long id);
    Cars selectCarById(@Param("id") Long id);
    Admin getAllLogin(@Param("username") String username);
    void updateDamage(@Param("id") Long id);
    boolean updateDamageCars(@Param("id") Long id, boolean status);
    boolean updateDamageCarsNull(@Param("id") Long id,boolean status);
    void updateDamagenull(@Param("id") Long id);
    boolean updateReason(@Param("id") Long id,@RequestBody String deviations,boolean disbalance);
    boolean updateBalance(@Param("id") Long id,@RequestBody Long balance, boolean disbalance);
    boolean updateDamageButton(@Param("id") Long id,boolean disbalance);
    ImageCars[] selectCarImages(@Param("id") Long id);

    ImageCars[] selectImages (@Param("id") Long id);
    boolean insertAccount(@RequestBody String login,String password);
    boolean insertAdmin(@RequestBody String login,String password);
    Admin getRoleName(@Param("id") Long id);
    List<Admin> findForLogin(@Param("login") String login,@Param("password") String password);
    Users selectUsersId(@Param("id") Long id);
    Admin invalid(@RequestBody String body);
    List<Users> getUser(@Param("userid") Long userid);
    Long insertCar(Cars cars);
    boolean insertImageCars(@Param("carsimage") String carsimage,@Param("carid") Long carid);
    Users getIdForUser (@Param("id") Long id);
    Admin findForIdLogin(@Param("userid") Long userid);
}
