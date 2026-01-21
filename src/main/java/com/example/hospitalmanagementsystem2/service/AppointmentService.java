package com.example.hospitalmanagementsystem2.service;

import com.example.hospitalmanagementsystem2.entity.Appointment;
import com.example.hospitalmanagementsystem2.entity.Doctor;
import com.example.hospitalmanagementsystem2.entity.Patient;
import com.example.hospitalmanagementsystem2.repository.AppointmentRepository;
import com.example.hospitalmanagementsystem2.repository.DoctorRepository;
import com.example.hospitalmanagementsystem2.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Appointment createAppointment(Appointment appointment,Long patientId,Long DoctorId){
        Doctor doctor= doctorRepository.findById(DoctorId).orElseThrow(()->new EntityNotFoundException(("Doctor Not Found")));
        Patient patient= patientRepository.findById(patientId).orElseThrow(()->new EntityNotFoundException(("Patient Not Found")));

        if (appointment.getId()!=null) throw new IllegalArgumentException("Appointment already exists");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);// this is to maintain by directional consistancy

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointmentToANewDoctor(Appointment appointmentId,Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId .getId()).orElseThrow(()->new EntityNotFoundException("Appointment Not Found"));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()->new EntityNotFoundException("Doctor Not Found"));
        appointment.setDoctor(doctor);
        doctor.getAppointmentList().add(appointment);
        return appointment;
    }





//    public Appointment updateAppointment(Appointment appointment,Long patientId,Long doctorId){
//        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()->new EntityNotFoundException("Doctor Not Found"));
//        Patient patient = patientRepository.findById(patientId).orElseThrow(()->new EntityNotFoundException("Patient Not Found"));
//
//        if (appointment.getId()==null) throw new IllegalArgumentException("No appointment exists with this id.");
//        appointment.setPatient(patient);
//        appointment.setDoctor(doctor);
//
//        return appointmentRepository.save(appointment);
//
//    }
}
