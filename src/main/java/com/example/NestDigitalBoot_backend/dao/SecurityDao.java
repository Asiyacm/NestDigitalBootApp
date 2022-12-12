package com.example.NestDigitalBoot_backend.dao;

import com.example.NestDigitalBoot_backend.Model.Employee;
import com.example.NestDigitalBoot_backend.Model.Security;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecurityDao extends CrudRepository<Security,Integer> {

    @Query(value = "SELECT `id`, `emp_code`, `name`, `password`, `username` FROM `security` WHERE `username`=:username AND `password`=:password", nativeQuery = true)
    List<Security> SecurityLogin(@Param("username") String username, @Param("password") String password);


    @Query(value = "SELECT `id`, `emp_code`, `name`, `password`, `username` FROM `security` WHERE `emp_code`=:emp_code", nativeQuery = true)
    List<Security> SecuritySearch(@Param("emp_code") Integer emp_code);


    @Modifying
    @Transactional

    @Query(value = "DELETE FROM `security` WHERE `id`=:id",nativeQuery = true)
    void SecurityDelete(@Param("id")Integer id);


    @Query(value = "SELECT `id`, `emp_code`, `name`, `password`, `username` FROM `security` WHERE `id`=:id",nativeQuery = true)
    List<Security> SecurityProfileView(@Param("id")Integer id);


}