package com.example.repository;

import com.example.entity.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<EducationDegree,Integer> {
}
