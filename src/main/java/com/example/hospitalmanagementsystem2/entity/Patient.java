package com.example.hospitalmanagementsystem2.entity;

import com.example.hospitalmanagementsystem2.entity.type.BloodGroudType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString
@Data
public class Patient {
    @Id
    private Long id;

    @Column(nullable = false,length = 50)

   private String name;
    @ToString.Exclude
   private LocalDate birthDate;
   private String gender;
   private String address;

   @Enumerated(EnumType.STRING)
   private BloodGroudType bloodGroup;

   @Column(unique = true)
   private String email;

   @CreationTimestamp
   @Column(updatable = false)
   private LocalDateTime createdAt;

   @OneToOne
   @JoinColumn(name = "patient_insurance_id",updatable = false)
   private Insurance insurance;

   @OneToMany(mappedBy = "patient")
   private List<Appointment> appointments;





}
