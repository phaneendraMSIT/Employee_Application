package com.springBoot.demo_Assignment.Repository;

import com.springBoot.demo_Assignment.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
