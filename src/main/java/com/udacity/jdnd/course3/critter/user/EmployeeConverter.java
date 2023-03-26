package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeConverter {
    public Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setEmployeeSkills(employeeDTO.getSkills());
        employee.setEmployeeDaysOfWeekAvailable(employeeDTO.getDaysAvailable());
        return employee;
    }

    public EmployeeDTO employeeToEmployeeDTO(Employee employee) {
        return EmployeeDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .skills(employee.getEmployeeSkills())
                .daysAvailable(employee.getEmployeeDaysOfWeekAvailable())
                .build();
    }

    public List<EmployeeDTO> employeeListToEmployeeDTOList(List<Employee> employees) {
        return employees.stream().map(this::employeeToEmployeeDTO).toList();
    }
}