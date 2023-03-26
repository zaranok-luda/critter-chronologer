package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.entity.Schedule;
import com.udacity.jdnd.course3.critter.entity.Employee;
import com.udacity.jdnd.course3.critter.entity.Pet;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScheduleConverter {
    public Schedule scheduleDTOToSchedule(ScheduleDTO dto) {
        Schedule schedule = new Schedule();
        schedule.setDate(dto.getDate());
        schedule.setSkills(dto.getActivities());
        return schedule;
    }

    public ScheduleDTO scheduleToScheduleDTO(Schedule schedule) {
        return ScheduleDTO.builder()
                .id(schedule.getId())
                .date(schedule.getDate())
                .activities(schedule.getSkills())
                .employeeIds(schedule.getEmployees().stream().map(Employee::getId).collect(Collectors.toSet()))
                .petIds(schedule.getPets().stream().map(Pet::getId).collect(Collectors.toSet()))
                .build();
    }

    public List<ScheduleDTO> scheduleListToScheduleDTOList(Collection<Schedule> schedules) {
        return schedules.stream().map(this::scheduleToScheduleDTO).toList();
    }
}