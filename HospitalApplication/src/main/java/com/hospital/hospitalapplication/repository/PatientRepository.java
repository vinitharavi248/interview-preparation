package com.hospital.hospitalapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.hospitalapplication.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}