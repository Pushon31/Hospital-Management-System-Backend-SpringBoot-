package com.example.hospitalmanagementsystem2.service;

import com.example.hospitalmanagementsystem2.entity.Insurance;
import com.example.hospitalmanagementsystem2.entity.Patient;
import com.example.hospitalmanagementsystem2.repository.InsuranceRepository;
import com.example.hospitalmanagementsystem2.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance,Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow(()->new EntityNotFoundException("Patient not found with id : "+patientId));
        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        return patient;
    }

    @Transactional

    public Patient deleteInsuranceFromPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow(()->new EntityNotFoundException("Patient not found with id : "+patientId));
        patient.setInsurance(null);
        return patient ;
    }

}
