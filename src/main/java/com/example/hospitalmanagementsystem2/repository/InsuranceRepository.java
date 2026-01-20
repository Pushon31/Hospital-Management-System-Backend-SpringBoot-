package com.example.hospitalmanagementsystem2.repository;

import com.example.hospitalmanagementsystem2.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Long> {
}
