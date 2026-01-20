package com.example.hospitalmanagementsystem2.repository;

import com.example.hospitalmanagementsystem2.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
