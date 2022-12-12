package com.example.NestDigitalBoot_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.web.bind.annotation.RestController;
@Entity
@Table(name="security")
public class Security {
    @Id
    @GeneratedValue
    private int id;
    private int empCode;
    private String name;
    private String username;
    private String password;

    public Security() {
    }

    public Security(int id, int empCode, String name, String username, String password) {
        this.id = id;
        this.empCode = empCode;
        this.name = name;
        this.username = username;
        this.password = password;
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
}




