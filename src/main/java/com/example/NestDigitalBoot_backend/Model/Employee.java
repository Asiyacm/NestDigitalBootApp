package com.example.NestDigitalBoot_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "employee")
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    private int empCode;
    private String name;
    private String emailId;
    private String designation;
    private String salary;
    private String address;
    private String mobile;
    private String username;
    private String password;
    private String cPassword;

    public Employee() {
    }

    public Employee(int id, int empCode, String name, String emailId, String designation, String salary, String address, String mobile, String username, String password, String cPassword) {
        this.id = id;
        this.empCode = empCode;
        this.name = name;
        this.emailId = emailId;
        this.designation = designation;
        this.salary = salary;
        this.address = address;
        this.mobile = mobile;
        this.username = username;
        this.password = password;
        this.cPassword = cPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpCode() {
        return empCode;
    }

    public void setEmpCode(int empCode) {
        this.empCode = empCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }
}



