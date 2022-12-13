package com.example.NestDigitalBoot_backend.dao;

import com.example.NestDigitalBoot_backend.Model.Leave;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository<Leave,Integer> {

    @Modifying
    @Query(value = "UPDATE `leave_table` SET `status`=:status WHERE `id`=:id",nativeQuery = true)
    void updatingById(@Param("status") Integer status,@Param("id") Integer id);


    @Query(value = "SELECT l.`id`, l.`apply_date`, l.`emp_id`, l.`from_date`, l.`remarks`, l.`status`, l.`to_date`,e.`id`,e.`name`,e.`designation` `type` FROM `leave_table` l JOIN employee e ON l.emp_id=e.id WHERE `status`=0",nativeQuery = true)
    List<Map<String,String>> LeaveApplyView();

    @Query(value = "SELECT l.`id`, l.`apply_date`, l.`emp_id`, l.`from_date`, l.`remarks`, l.`status`, l.`to_date`,l.`type`,e.`id`,e.`name`,e.`designation`  FROM `leave_table` l JOIN employee e ON l.emp_id=e.id WHERE l.emp_id=:emp_id",nativeQuery = true)
    List<Map<String,String>> viewLeaveById(@Param("emp_id")Integer emp_id);

}
