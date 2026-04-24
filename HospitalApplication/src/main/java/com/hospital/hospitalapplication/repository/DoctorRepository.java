package com.hospital.hospitalapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.hospitalapplication.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}