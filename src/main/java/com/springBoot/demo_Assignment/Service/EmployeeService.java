package com.springBoot.demo_Assignment.Service;

import com.springBoot.demo_Assignment.Entity.Employee;
import com.springBoot.demo_Assignment.Entity.EmployeeDTO;
import com.springBoot.demo_Assignment.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@SuppressWarnings("unused")
public class EmployeeService {

    @Autowired
   private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findall(){

        return employeeRepository.findAllByOrderBySalaryDesc();
   }

    private static EmployeeDTO EtoDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setDob(employee.getDob());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setDepartment(employee.getDepartment());

        return employeeDTO;
    }

    static List<String> EtoDTO(List<Employee> employees){
        List<String> employeeDTOS = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDTO tempEmployeeDTO = EtoDTO(employee);
            employeeDTOS.add(tempEmployeeDTO.getFirstName() + " " + tempEmployeeDTO.getLastName());
        }
        return employeeDTOS;
    }

    public Employee findById(int employeeId) {
       Optional<Employee> employee = employeeRepository.findById(employeeId);

        return employee.orElse(null);
    }


    public String addEmployee(Employee employee) {
       if (!check(employee)){
           employeeRepository.save(employee);
           return "Employee has been added";
       }else {
           return "Employee already exists";
       }

    }

    private boolean check(Employee tempemployee) {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().anyMatch((employee) -> employee.getFirstName().equals(tempemployee.getFirstName())
                && employee.getLastName().equals(tempemployee.getLastName()));
    }

    public void deleteById(int employeeId) {
       employeeRepository.deleteById(employeeId);
    }

    public void updateService(Employee employee) {
           employeeRepository.save(employee);

    }

    public List<Employee> sortedList() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().sorted(Comparator.comparingInt(Employee::getSalary)
                .reversed()).collect(Collectors.toList());
    }
}
