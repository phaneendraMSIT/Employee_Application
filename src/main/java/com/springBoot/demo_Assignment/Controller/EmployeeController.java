package com.springBoot.demo_Assignment.Controller;


import com.springBoot.demo_Assignment.Entity.Employee;
import com.springBoot.demo_Assignment.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud")
public class EmployeeController  {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> findAll(){
        return employeeService.findall();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee findById(@PathVariable int employeeId)
    {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new EmployeeNotFoundException("Customer Id not found -"+employeeId);
        }
        return employee;
    }

    @PostMapping("/employee")
    public String addEmployee(@RequestBody Employee employee)
    {
       return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/employee/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){

        employeeService.deleteById(employeeId);
    }

    @PutMapping("/employee")
    public ResponseEntity updateEmployee(@RequestBody Employee employee){
        //employ existence check here
        Employee em = employeeService.findById(employee.getId());
        if(em==null){
            return  ResponseEntity.badRequest().build();
        }

        employeeService.updateService(employee);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/sorted")
    public List<Employee> SortedList(){
       return employeeService.sortedList();
    }
}
