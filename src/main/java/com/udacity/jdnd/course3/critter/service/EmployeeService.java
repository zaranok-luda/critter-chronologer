package com.udacity.jdnd.course3.critter.service;

import com.google.common.collect.Sets;
import com.udacity.jdnd.course3.critter.entity.Employee;
import com.udacity.jdnd.course3.critter.exception.EmployeeNotAvailableForServiceException;
import com.udacity.jdnd.course3.critter.exception.EmployeeNotFoundException;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getAllEmployeesById(Set<Long> ids) {
        return employeeRepository.findAllById(ids);
    }

    public Set<Long> getAllEmployeesIdByIdSet(Set<Long> ids) {
        return getAllEmployeesById(ids).stream().map(Employee::getId).collect(Collectors.toSet());
    }

    public void validateEmployeesId(Set<Long> ids) {
        Set<Long> savedEmployees = getAllEmployeesIdByIdSet(ids);
        HashSet<Long> result = Sets.newHashSet(ids);
        result.removeAll(savedEmployees);
        if (!result.isEmpty()) {
            throw new EmployeeNotFoundException(result);
        }
    }

    public void validateEmployeesAvailability(LocalDate date, Set<Long> ids, Set<EmployeeSkill> skills) {
        Set<Long> availableEmployees = getAvailableEmployeesForService(date, skills).stream().map(Employee::getId).collect(Collectors.toSet());
        HashSet<Long> result = Sets.newHashSet(ids);
        result.removeAll(availableEmployees);
        if (!result.isEmpty()) {
            throw new EmployeeNotAvailableForServiceException(result);
        }
    }

    public void validateEmployees(LocalDate date, Set<Long> ids, Set<EmployeeSkill> skills, List<String> errors) {
        try {
            validateEmployeesId(ids);
        } catch (EmployeeNotFoundException e) {
            errors.add(e.getMessage());
        }

        try {
            validateEmployeesAvailability(date, ids, skills);
        } catch (EmployeeNotAvailableForServiceException e) {
            errors.add(e.getMessage());
        }
    }

    public Employee getEmployeeByID(long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException(employeeId));
    }

    public void deleteEmployeeByID(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public List<Employee> getAvailableEmployeesForService(LocalDate date, Set<EmployeeSkill> skills) {
        return employeeRepository.findByEmployeeDaysOfWeekAvailable(date.getDayOfWeek()).stream()
                .filter(e -> e.getEmployeeSkills().containsAll(skills))
                .collect(toList());
    }

}
