package com.example.employeepayrollapp.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.employeepayrollapp.model.EmployeePayroll;
import com.example.employeepayrollapp.repository.EmployeePayrollRepository;

import java.util.List;
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	@Autowired
    private EmployeePayrollRepository repository;

    @GetMapping("/")
    public String home() {
        return "Welcome to Employee Payroll App";
    }

    @GetMapping("/get")
    public List<EmployeePayroll> getAllEmployees() {
        return repository.findAll();
    }

    @GetMapping("/get/{id}")
    public EmployeePayroll getEmployeeById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @PostMapping("/create")
    public EmployeePayroll createEmployee(@Valid @RequestBody EmployeePayroll employee) {
        return repository.save(employee);
    }

    @PutMapping("/update/{id}")
    public EmployeePayroll updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeePayroll employeeDetails) {
        EmployeePayroll employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setName(employeeDetails.getName());
        employee.setSalary(employeeDetails.getSalary());
        return repository.save(employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
        return "Deleted successfully";
    }
}
