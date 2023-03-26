package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Represents the form that schedule request and response data takes. Does not map
 * to the database directly.
 */
public class ScheduleDTO {
    private long id;
    private Set<Long> employeeIds;
    private Set<Long> petIds;
    private LocalDate date;
    private Set<EmployeeSkill> activities;

    public long getId(){
        return id;
    }
    
    public void setId(long id){
        this.id = id;
    }
    
    public Set<Long> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(Set<Long> employeeIds) {
        this.employeeIds = employeeIds;
    }

    public Set<Long> getPetIds() {
        return petIds;
    }

    public void setPetIds(Set<Long> petIds) {
        this.petIds = petIds;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<EmployeeSkill> getActivities() {
        return activities;
    }

    public void setActivities(Set<EmployeeSkill> activities) {
        this.activities = activities;
    }

    public ScheduleDTO() {
    }

    public ScheduleDTO(long id, Set<Long> employeeIds, Set<Long> petIds, LocalDate date, Set<EmployeeSkill> activities) {
        this.id = id;
        this.employeeIds = employeeIds;
        this.petIds = petIds;
        this.date = date;
        this.activities = activities;
    }

    public static ScheduleDTO.ScheduleDTOBuilder builder() {
        return new ScheduleDTO.ScheduleDTOBuilder();
    }

    public static class ScheduleDTOBuilder {
        private long id;
        private Set<Long> employeeIds;
        private Set<Long> petIds;
        private LocalDate date;
        private Set<EmployeeSkill> activities;

        public ScheduleDTO.ScheduleDTOBuilder id(long id) {
            this.id = id;
            return this;
        }

        public ScheduleDTO.ScheduleDTOBuilder employeeIds(Set<Long> employeeIds) {
            this.employeeIds = employeeIds;
            return this;
        }

        public ScheduleDTO.ScheduleDTOBuilder petIds(Set<Long> petIds) {
            this.petIds = petIds;
            return this;
        }

        public ScheduleDTO.ScheduleDTOBuilder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public ScheduleDTO.ScheduleDTOBuilder activities(Set<EmployeeSkill> activities) {
            this.activities = activities;
            return this;
        }

        public ScheduleDTO build() {
            return new ScheduleDTO(id, employeeIds, petIds, date, activities);
        }
    }
}
