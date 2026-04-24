package com.hospital.hospitalapplication.controller;
import com.hospital.hospitalapplication.entity.Appointment;
import com.hospital.hospitalapplication.entity.Doctor;
import com.hospital.hospitalapplication.entity.Patient;
import com.hospital.hospitalapplication.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService service;

    @PostMapping("/patient")
    public Patient addPatient(@RequestBody Patient patient) {
        return service.addPatient(patient);
    }

    @PostMapping("/doctor")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return service.addDoctor(doctor);
    }

    @PostMapping("/appointment")
    public Appointment book(@RequestParam Long patientId,
                            @RequestParam Long doctorId) {
        return service.bookAppointment(patientId, doctorId);
    }

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return service.getPatients();
    }

    @GetMapping("/doctors")
    public List<Doctor> getDoctors() {
        return service.getDoctors();
    }

    @GetMapping("/appointments")
    public List<Appointment> getAppointments() {
        return service.getAppointments();
    }
}