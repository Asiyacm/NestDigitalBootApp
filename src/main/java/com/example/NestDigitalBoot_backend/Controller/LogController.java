package com.example.NestDigitalBoot_backend.Controller;

import com.example.NestDigitalBoot_backend.Model.EmployeeLog;
import com.example.NestDigitalBoot_backend.Model.VisitorLog;
import com.example.NestDigitalBoot_backend.dao.EmployeeLogDao;
import com.example.NestDigitalBoot_backend.dao.VisitorLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LogController {


    @Autowired
    private EmployeeLogDao daoE;

    @Autowired
    private VisitorLogDao daoV;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/employeeLog",consumes = "application/json",produces = "application/json")
    public Map<String,String> EmployLog(@RequestBody EmployeeLog emp)
    {

        daoE.save(emp);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/logEmployeeView")
    public List<EmployeeLog> ViewAllEmployeeLog()
    {
        return (List<EmployeeLog>) daoE.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/logEmployeeViewDaily",consumes = "application/json",produces = "application/json")
    public List<EmployeeLog> viewDailyEmployeeLog(@RequestBody EmployeeLog emp)
    {
        return (List<EmployeeLog>) daoE.viewDailyEmployeeLog(emp.getDate());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/logVisitor",consumes = "application/json",produces = "application/json")
    public Map<String,String> VisitorLog(@RequestBody VisitorLog v)
    {

        daoV.save(v);
        HashMap<String,String> map =new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/logVisitorView")
    public List<VisitorLog> ViewAllVisitorLog()
    {
        return (List<VisitorLog>) daoV.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/logVisitorViewDaily",consumes = "application/json",produces = "application/json")
    public List<VisitorLog> ViewDailyVisitorLog(@RequestBody VisitorLog v)
    {
        return (List<VisitorLog>) daoV.ViewDailyVisitorLog(v.getDate());
    }






}



