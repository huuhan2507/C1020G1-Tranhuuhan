package com.example.service.impl;

import com.example.entity.employee.Division;
import com.example.entity.employee.EducationDegree;
import com.example.entity.employee.Employee;
import com.example.entity.employee.Position;
import com.example.entity.login.Role;
import com.example.entity.login.User;
import com.example.entity.login.UserRole;
import com.example.repository.*;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private DivisionRepository divisionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll( pageable );
    }

    @Override
    public void save(Employee employee,String password,String username) {
        User user = new User();
        user.setPassWord( password );
        user.setUserName( username );
        userRepository.save( user );
        UserRole userRole = new UserRole();
        if (employee.getPosition().getPositionId()==5|employee.getPosition().getPositionId()==5){
            Role role = new Role();
            role.setRoleId( 1 );
            role.setRoleName( "ROLE_MANAGER" );
            userRole.setRole( role );
            userRole.setUser( user );
        }else {
            Role role = new Role();
            role.setRoleId( 2 );
            role.setRoleName( "ROLE_EMPLOYEE" );
            userRole.setRole( role );
            userRole.setUser( user );
        }
        employee.setUser( user );
        userRoleRepository.save( userRole );
        employeeRepository.save( employee );
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById( id );
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> search(String search, Pageable pageable) {
        return employeeRepository.findByContaining( search,pageable );
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById( id ).orElse( null );
    }

    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAll();
    }

    @Override
    public List<Division> findAllDivision() {
        return divisionRepository.findAll();
    }

    @Override
    public List<EducationDegree> findAllEducation() {
        return educationRepository.findAll();
    }
}
