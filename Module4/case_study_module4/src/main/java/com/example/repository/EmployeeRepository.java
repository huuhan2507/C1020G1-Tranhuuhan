package com.example.repository;


import com.example.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findEmployeeByEmployeeNameContains(String name, Pageable pageable);
}
