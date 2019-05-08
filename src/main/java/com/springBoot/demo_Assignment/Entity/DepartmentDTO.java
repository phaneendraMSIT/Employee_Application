package com.springBoot.demo_Assignment.Entity;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unused")
public class DepartmentDTO implements Serializable {


    public int id;

    public String departmentName;

    public List<String> employees;

    public DepartmentDTO() {
    }

    public DepartmentDTO(int id) {
        this.id = id;
    }

    public DepartmentDTO(int id, String departmentName, List<String> employees) {
        this.id = id;
        this.departmentName = departmentName;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<String> getEmployees() {
        return employees;
    }

    public void setEmployees(List<String> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
