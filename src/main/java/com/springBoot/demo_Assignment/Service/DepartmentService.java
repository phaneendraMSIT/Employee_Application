package com.springBoot.demo_Assignment.Service;

import com.springBoot.demo_Assignment.Entity.Department;
import com.springBoot.demo_Assignment.Entity.DepartmentDTO;
import com.springBoot.demo_Assignment.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentDTO> findAll(){
        List<Department> departments = (List<Department>)departmentRepository.findAll();
        List<DepartmentDTO>departmentDTOS = toDto(departments);

        return departmentDTOS.stream().sorted(Comparator.comparing(DepartmentDTO -> DepartmentDTO.departmentName))
                .collect(Collectors.toList());
    }

    private static DepartmentDTO toDto(Department department){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setEmployees(EmployeeService.EtoDTO(department.getEmployees()));
        departmentDTO.setDepartmentName(department.getDepartmentName());
        return departmentDTO;
    }

    public static List<DepartmentDTO> toDto(List<Department> departments){
        //use above method
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();
        for (Department department : departments) {
            departmentDTOS.add(toDto(department));
        }
        return departmentDTOS;
    }

    public DepartmentDTO findById(int departmentId) {

        Optional<Department> department = departmentRepository.findById(departmentId);
        return toDto(department.orElse(null));
    }

    public void addDepartment(Department department) {

        departmentRepository.save(department);
    }


    public void deleteById(int departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    public void updateDepartment(Department department, int departmentId) {
        if (departmentId == department.getId()){
            departmentRepository.save(department);
        }else {
            throw new RuntimeException("check your input");
        }
    }
}
