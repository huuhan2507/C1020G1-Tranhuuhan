package com.example.repository;

import com.example.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findAll(Pageable pageable);

    @Query(value = "select * from employee e where concat(e.employee_id,e.employee_name,e.employee_phone,e.employee_email) like %:key%", nativeQuery = true)
    Page<Employee> findByContaining(@Param("key") String key, Pageable pageable);
}
