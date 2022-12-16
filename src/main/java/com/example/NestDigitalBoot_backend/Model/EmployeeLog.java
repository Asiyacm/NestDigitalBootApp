package com.example.NestDigitalBoot_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_log")
public class EmployeeLog {

    @Id
    @GeneratedValue
    private int id;
    private int empId;
    private String date;
    private String entryDateTime;
    private String exitDateTime;

    public EmployeeLog() {
    }

    public EmployeeLog(int id, int empId, String date, String entryDateTime, String exitDateTime) {
        this.id = id;
        this.empId = empId;
        this.date = date;
        this.entryDateTime = entryDateTime;
        this.exitDateTime = exitDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEntryDateTime() {
        return entryDateTime;
    }

    public void setEntryDateTime(String entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    public String getExitDateTime() {
        return exitDateTime;
    }

    public void setExitDateTime(String exitDateTime) {
        this.exitDateTime = exitDateTime;
    }
}


