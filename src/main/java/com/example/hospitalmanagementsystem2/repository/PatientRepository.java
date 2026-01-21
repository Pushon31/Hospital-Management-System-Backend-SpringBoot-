package com.example.hospitalmanagementsystem2.repository;

import com.example.hospitalmanagementsystem2.entity.Patient;
import com.example.hospitalmanagementsystem2.entity.type.BloodGroudType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {


    Patient findByName(String name);

    Patient findByBloodGroup(BloodGroudType bloodGroup);

    Patient findByBirthDate(LocalDate birthDate);

    @Query("SELECT p from Patient p where p.bloodGroup=?1")

    List<Patient> findByBloodGroup(@Param("bloodGroup") String bloodGroup);

    @Query("select p from Patient p where p.birthDate > : birthdate")

    List<Patient> findByBornAfter(@Param("birthDate") LocalDate birthDate);

    @Query("select p.bloodGroup,count (p) from Patient p group by p.bloodGroup")
    List<Object[]> countByBloodGroupType(@Param("bloodGroup") BloodGroudType bloodGroup);

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = : name")
    int updateNameWithId (@Param("name")String name,@Param("id") Long id);

    @Query("select p from Patient p left join fetch p.appointments")
    List<Patient> findAllPatientWithAppoinment();
}
