package com.springBoot.demo_Assignment.Repository;

import com.springBoot.demo_Assignment.Entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {



    List<Employee> findAllByOrderBySalaryDesc();
}
