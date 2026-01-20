package com.example.hospitalmanagementsystem2.service;

import com.example.hospitalmanagementsystem2.entity.Patient;
import com.example.hospitalmanagementsystem2.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(long id){

        Patient p1=patientRepository.findById(id).orElseThrow();


        return p1;

    }
}
