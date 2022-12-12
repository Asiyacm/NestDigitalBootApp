package com.example.NestDigitalBoot_backend.Controller;

import com.example.NestDigitalBoot_backend.Model.Employee;
import com.example.NestDigitalBoot_backend.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
public class AdminController {
    @Autowired
    private EmployeeDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path="/login",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> EmployeeLogin(@RequestBody Employee e){
        List<Employee> result=(List<Employee>) dao.EmployeeLogin(e.getUsername(),e.getPassword());
        System.out.println(e.toString());
        HashMap<String,String> map=new HashMap<>();
        if (result.size()==0)
        {
            map.put("status","failed");
        }
        else
        {

            map.put("status","success");
            map.put("userId",String.valueOf(result.get(0).getId()));

        }
        return map;

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path="/add",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> EmployeeAdd(@RequestBody Employee e){
        System.out.println(e.toString());
        HashMap<String,String> map=new HashMap<>();
        dao.save(e);
        map.put("id",String.valueOf(e.getId()));
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/profile",consumes="application/json",produces = "application/json")
    public List<Employee> EmployeeViewProfile(@RequestBody Employee e){
        return dao.EmployeeViewProfile(e.getId());
    }





    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Employee> view()
    {
        return (List<Employee>) dao.findAll();
    }




    @CrossOrigin(origins ="*")
    @PostMapping(path ="/search",consumes = "application/json",produces = "application/json")
    public  List<Employee> EmployeeSearch(@RequestBody Employee e) {
        String empcode = String.valueOf(e.getEmpCode());
        System.out.println(empcode);
        return (List<Employee>) dao.EmployeeSearch(e.getEmpCode());
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> EmployeeDelete(@RequestBody Employee e)
    {
        String id = String.valueOf(e.getId());
        System.out.println(id);
        dao.EmployeeDelete(e.getId());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }


}
