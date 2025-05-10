package com.example.demo.controller;

import com.example.demo.beans.EmployeeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeBean employee;

    @GetMapping("/department")
    public String getDepartment() {
        return "Injected Department: " + employee.getDepartment().getDeptName();
    }

    @GetMapping("/")
    public String welcome() {
        return "Welcome to the Dependency Injection Demo!";
    }
}
