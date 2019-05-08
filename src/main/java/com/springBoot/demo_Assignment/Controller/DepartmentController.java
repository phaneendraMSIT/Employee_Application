package com.springBoot.demo_Assignment.Controller;

import com.springBoot.demo_Assignment.Entity.Department;
import com.springBoot.demo_Assignment.Entity.DepartmentDTO;
import com.springBoot.demo_Assignment.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/crud")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department")
    public List<DepartmentDTO> findAll(){
        return departmentService.findAll();
    }

    @GetMapping("/department/{departmentId}")
    public DepartmentDTO findById(@PathVariable int departmentId){

        return departmentService.findById(departmentId);
    }

    @PostMapping("/department")
    public  void addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
    }

    @DeleteMapping("/department/{departmentId}")
    public void deleteById(@PathVariable int departmentId){
        departmentService.deleteById(departmentId);
    }

    @PutMapping("/department/{departmentId}")
    public  String updateDepartment(@RequestBody Department department, @PathVariable int departmentId){

        departmentService.updateDepartment(department,departmentId);

        return "department is updated";
    }
}
