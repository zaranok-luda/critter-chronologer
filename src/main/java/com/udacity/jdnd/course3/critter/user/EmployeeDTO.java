package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.pet.PetDTO;
import com.udacity.jdnd.course3.critter.pet.PetType;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;

/**
 * Represents the form that employee request and response data takes. Does not map
 * to the database directly.
 */
public class EmployeeDTO {
    private long id;
    private String name;
    private Set<EmployeeSkill> skills;
    private Set<DayOfWeek> daysAvailable;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }

    public Set<DayOfWeek> getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(Set<DayOfWeek> daysAvailable) {
        this.daysAvailable = daysAvailable;
    }

    public EmployeeDTO() {
    }

    public EmployeeDTO(long id, String name, Set<EmployeeSkill> skills, Set<DayOfWeek> daysAvailable) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.daysAvailable = daysAvailable;
    }

    public static EmployeeDTO.EmployeeDTOBuilder builder() {
        return new EmployeeDTO.EmployeeDTOBuilder();
    }

    public static class EmployeeDTOBuilder {
        private long id;
        private String name;
        private Set<EmployeeSkill> skills;
        private Set<DayOfWeek> daysAvailable;

        public EmployeeDTO.EmployeeDTOBuilder id(long id) {
            this.id = id;
            return this;
        }

        public EmployeeDTO.EmployeeDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeDTO.EmployeeDTOBuilder skills(Set<EmployeeSkill> skills) {
            this.skills = skills;
            return this;
        }

        public EmployeeDTO.EmployeeDTOBuilder daysAvailable(Set<DayOfWeek> daysAvailable) {
            this.daysAvailable = daysAvailable;
            return this;
        }

        public EmployeeDTO build() {
            return new EmployeeDTO(id, name, skills, daysAvailable);
        }
    }
}
