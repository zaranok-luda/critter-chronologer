package com.udacity.jdnd.course3.critter.entity;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ElementCollection
    @JoinTable(name = "employee_skill")
    private Set<EmployeeSkill> employeeSkills;
    @ElementCollection
    @JoinTable(name = "employee_dow_available")
    @Column(name = "daysOfWeekAvailable")
    private Set<DayOfWeek> employeeDaysOfWeekAvailable;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EmployeeSkill> getEmployeeSkills() {
        return employeeSkills;
    }

    public void setEmployeeSkills(Set<EmployeeSkill> employeeSkills) {
        this.employeeSkills = employeeSkills;
    }

    public Set<DayOfWeek> getEmployeeDaysOfWeekAvailable() {
        return employeeDaysOfWeekAvailable;
    }

    public void setEmployeeDaysOfWeekAvailable(Set<DayOfWeek> employeeDaysOfWeekAvailable) {
        this.employeeDaysOfWeekAvailable = employeeDaysOfWeekAvailable;
    }
}