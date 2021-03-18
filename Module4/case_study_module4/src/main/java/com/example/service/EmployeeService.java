package com.example.service;

import com.example.entity.employee.Division;
import com.example.entity.employee.EducationDegree;
import com.example.entity.employee.Employee;
import com.example.entity.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee, String password,String username);

    void deleteById(Integer id);

    void deleteAll();

    List<Employee> findAll();

    Page<Employee> search(String search, Pageable pageable);

    Employee findById(Integer id);

    List<Position> findAllPosition();

    List<Division> findAllDivision();

    List<EducationDegree> findAllEducation();
}
