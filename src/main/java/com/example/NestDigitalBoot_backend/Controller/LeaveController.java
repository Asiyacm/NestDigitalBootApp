package com.example.NestDigitalBoot_backend.Controller;

import com.example.NestDigitalBoot_backend.Model.Leave;
import com.example.NestDigitalBoot_backend.Model.Security;
import com.example.NestDigitalBoot_backend.dao.LeaveDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {

    @Autowired
    private LeaveDao ldao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/lAdd", consumes = "application/json", produces = "application/json")
    public String addLeave(@RequestBody Leave l) {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = String.valueOf((dt.format(now)));
        l.setApplyDate(currentDate);

        ldao.save(l);
        return "{status:'success'}";
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/updatedStatus",consumes = "application/json",produces = "application/json")
    public String StatusUpdate(@RequestBody Leave l){
        ldao.updatingById(l.getStatus(),l.getId());
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/lView")
    public List<Leave> LeaveViewAll()
    {
        return (List<Leave>) ldao.findAll();
    }

//    @CrossOrigin(origins = "*")
//    @GetMapping("/lApplyView")
//    public List<Map<String, String>> LeaveApplyView() {
//        return (List<Map<String, String>>) ldao.LeaveApplyView();
//
//    }

//    @CrossOrigin(origins = "*")
//    @PostMapping(path = "/lViewId",consumes = "application/json",produces = "application/json")
//    public  List<Map<String,String>> viewLeavesById(@RequestBody Leave l){
//        return (List<Map<String, String>>) ldao.viewLeaveById(l.getEmpId());
//    }


}
