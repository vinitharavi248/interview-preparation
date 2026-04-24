package com.hospital.hospitalapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.hospitalapplication.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}