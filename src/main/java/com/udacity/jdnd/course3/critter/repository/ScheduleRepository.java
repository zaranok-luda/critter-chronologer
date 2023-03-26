package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByPetsId(Long petId);

    List<Schedule> findAllByEmployeesId(Long employeeId);

    Set<Schedule> getAllSchedulesByPetsCustomerId(Long customerId);
}
