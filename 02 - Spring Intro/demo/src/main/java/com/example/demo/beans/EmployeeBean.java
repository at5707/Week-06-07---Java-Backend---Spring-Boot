package com.example.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeBean {

    @Autowired
    private DepartmentBean department;

    public DepartmentBean getDepartment() {
        return department;
    }

    public void showDepartment() {
        System.out.println("Injected Department: " + department.getDeptName());
    }
}
