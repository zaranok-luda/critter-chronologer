package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.entity.Schedule;
import com.udacity.jdnd.course3.critter.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ScheduleConverter scheduleConverter;

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleConverter.scheduleDTOToSchedule(scheduleDTO);
        Schedule scheduleSaved = scheduleService.saveSchedule(schedule, scheduleDTO.getPetIds(), scheduleDTO.getEmployeeIds());
        return scheduleConverter.scheduleToScheduleDTO(scheduleSaved);
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        return scheduleConverter.scheduleListToScheduleDTOList(scheduleService.getAllSchedules());
    }

    @GetMapping("/{scheduleId}")
    public ScheduleDTO getScheduleById(@PathVariable long scheduleId) {
        return scheduleConverter.scheduleToScheduleDTO(scheduleService.getScheduleByID(scheduleId));
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        return scheduleConverter.scheduleListToScheduleDTOList(scheduleService.getAllSchedulesByPetId(petId));
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        return scheduleConverter.scheduleListToScheduleDTOList(scheduleService.getAllSchedulesByEmployeeId(employeeId));
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        Set<Schedule> schedules = scheduleService.getAllSchedulesByCustomerId(customerId);
        return scheduleConverter.scheduleListToScheduleDTOList(schedules);
    }
}
