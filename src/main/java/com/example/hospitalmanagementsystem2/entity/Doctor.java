package com.example.hospitalmanagementsystem2.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 100)
    private String name;

    @Column(nullable = false,length = 100)
    private String address;

    @Column(nullable = false,length = 100,unique = true)
    private String email;

    @Column(length = 100)
    private String specialization;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointmentList;

    @ManyToMany(mappedBy = "doctors")
    private List<Department> departments;




}
