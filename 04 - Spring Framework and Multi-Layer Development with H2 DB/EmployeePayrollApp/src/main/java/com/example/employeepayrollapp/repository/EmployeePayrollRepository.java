package com.example.employeepayrollapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeepayrollapp.model.EmployeePayroll;
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayroll, Long> {
}