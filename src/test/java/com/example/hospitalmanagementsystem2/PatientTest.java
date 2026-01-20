package com.example.hospitalmanagementsystem2;

import com.example.hospitalmanagementsystem2.entity.Patient;
import com.example.hospitalmanagementsystem2.entity.type.BloodGroudType;
import com.example.hospitalmanagementsystem2.repository.PatientRepository;
import com.example.hospitalmanagementsystem2.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientService patientService;

    @Test
    public void testPatientRepository(){
       List<Patient> patientList=patientRepository.findAll();
        System.out.println(patientList);



    }

    @Test
    public void testTransactionMethods(){
//        Patient patient = patientService.getPatientById(1l);

//        Patient patient = patientRepository.findByName("Syed Sams");

//        Patient patient = patientRepository.findByBloodGroup(BloodGroudType.valueOf("A_Positive"));

//    Patient patient = patientRepository.findByBirthDate(LocalDate.of(2000,3,15));
//        Patient patient = patientRepository.findByBloodGroup(BloodGroudType.A_Positive);

        List<Patient> patient = patientRepository.findByBornAfter(LocalDate.of(2000,3,15));


        System.out.println(patient);

    }


}
