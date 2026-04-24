package com.hospital.hospitalapplication.service;
import com.hospital.hospitalapplication.entity.Appointment;
import com.hospital.hospitalapplication.entity.Doctor;
import com.hospital.hospitalapplication.entity.Patient;
import com.hospital.hospitalapplication.repository.AppointmentRepository;
import com.hospital.hospitalapplication.repository.DoctorRepository;
import com.hospital.hospitalapplication.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class HospitalService {

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private AppointmentRepository appointmentRepo;

    public Patient addPatient(Patient p) {
        return patientRepo.save(p);
    }

    public Doctor addDoctor(Doctor d) {
        return doctorRepo.save(d);
    }

    public Appointment bookAppointment(Long patientId, Long doctorId) {

        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepo.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Appointment ap = new Appointment();
        ap.setPatient(patient);
        ap.setDoctor(doctor);

        return appointmentRepo.save(ap);
    }

    public List<Patient> getPatients() {
        return patientRepo.findAll();
    }

    public List<Doctor> getDoctors() {
        return doctorRepo.findAll();
    }

    public List<Appointment> getAppointments() {
        return appointmentRepo.findAll();
    }
}