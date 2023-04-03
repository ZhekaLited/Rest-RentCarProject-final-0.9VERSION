package com.example.restrentcarproject.mapper;

import com.example.restrentcarproject.model.Admin;
import com.example.restrentcarproject.model.Cars;
import com.example.restrentcarproject.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface CarsMapper {

    List<Cars> selectAllCars();

    boolean insertUser(Users users);

    List<Users> selectAllUsers();

    boolean deleteUser(@Param("id") Long id);

    Cars selectCarById(@Param("id") Long id);

    Users selectUsersId(@Param("id") Long id);

    Admin getAllLogin(@Param("username") String username);

    List<Cars> carsId(@Param("carsid") Long carsid);

    boolean updateDamage(@Param("id") Long id);

    boolean updateDamagenull(@Param("id") Long id);

    boolean updateReason(@Param("id") Long id,@RequestBody String deviations);

}
