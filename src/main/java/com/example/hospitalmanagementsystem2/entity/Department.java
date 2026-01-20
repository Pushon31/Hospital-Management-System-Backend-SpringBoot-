package com.example.hospitalmanagementsystem2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,length = 100)
    private String name;

    @OneToOne
    @JoinColumn
    private Doctor headDoctor;

    @ManyToMany
    @JoinTable(name = "dpt_doctors",
    joinColumns = @JoinColumn(name = "dpt_id"),
    inverseJoinColumns = @JoinColumn(name = "doc_id"))
    private List<Doctor> doctors;

}
