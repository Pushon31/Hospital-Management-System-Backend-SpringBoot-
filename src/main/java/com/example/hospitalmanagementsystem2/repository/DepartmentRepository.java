package com.example.hospitalmanagementsystem2.repository;

import com.example.hospitalmanagementsystem2.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
