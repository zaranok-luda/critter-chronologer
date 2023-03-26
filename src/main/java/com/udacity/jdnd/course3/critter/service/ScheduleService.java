package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entity.Schedule;
import com.udacity.jdnd.course3.critter.exception.InvalidScheduleException;
import com.udacity.jdnd.course3.critter.exception.ScheduleNotFoundException;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ScheduleService {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PetService petService;
    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule getScheduleByID(long scheduleId) {
        return scheduleRepository.findById(scheduleId).orElseThrow(() -> new ScheduleNotFoundException(scheduleId));
    }

    public List<Schedule> getAllSchedulesByPetId(long petId) {
        return scheduleRepository.findAllByPetsId(petId);
    }

    public List<Schedule> getAllSchedulesByEmployeeId(long employeeId) {
        return scheduleRepository.findAllByEmployeesId(employeeId);
    }

    public Set<Schedule> getAllSchedulesByCustomerId(long customerId) {
        return scheduleRepository.getAllSchedulesByPetsCustomerId(customerId);
    }

    public Schedule saveSchedule(Schedule schedule, Set<Long> petIds, Set<Long> employeeIds) {
        validateSchedule(schedule, petIds, employeeIds);

        schedule.setEmployees(employeeService.getAllEmployeesById(employeeIds));
        schedule.setPets(petService.getAllPetsById(petIds));

        return scheduleRepository.save(schedule);
    }

    private void validateSchedule(Schedule schedule, Set<Long> petIds, Set<Long> employeeIds) {
        List<String> validationErrors = new ArrayList<>();

        employeeService.validateEmployees(schedule.getDate(), employeeIds, schedule.getSkills(), validationErrors);
        petService.validatePets(petIds, validationErrors);

        if (!validationErrors.isEmpty()) {
            throw new InvalidScheduleException(validationErrors);
        }
    }
}