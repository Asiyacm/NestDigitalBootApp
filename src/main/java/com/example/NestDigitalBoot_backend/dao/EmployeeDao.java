package com.example.NestDigitalBoot_backend.dao;

import com.example.NestDigitalBoot_backend.Model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee,Integer>{

    @Query(value = "SELECT `id`, `address`, `c_password`, `designation`, `email_id`, `emp_code`, `mobile`, `name`, `password`, `salary`, `username` FROM `employee` WHERE `username`=:username AND `password`=:password",nativeQuery = true)
    List<Employee>EmployeeLogin(@Param("username") String username,@Param("password") String password);

    @Query(value = "SELECT `id`, `address`, `c_password`, `designation`, `email_id`, `emp_code`, `mobile`, `name`, `password`, `salary`, `username` FROM `employee` WHERE `emp_code`=:emp_code",nativeQuery = true)
    List<Employee>EmployeeSearch(@Param("emp_code") Integer emp_code );

@Modifying
@Transactional
    @Query(value = "DELETE FROM `employee` WHERE `id`=:id",nativeQuery = true)
    void EmployeeDelete(@Param("id")Integer id );


    @Query(value = "SELECT `id`, `address`, `c_password`, `designation`, `email_id`, `emp_code`, `mobile`, `name`, `password`, `salary`, `username` FROM `employee` WHERE `id`=:id",nativeQuery = true)
    List<Employee>EmployeeViewProfile(@Param("id") Integer id );

}
