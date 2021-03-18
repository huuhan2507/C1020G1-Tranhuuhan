package service.impl;

import bean.employee.Employee;
import repository.EmployeeRepository;
import repository.impl.EmployeeRepositoryImpl;
import service.EmployeeService;
import service.checkvalidate.Regex;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    Regex regex = new Regex();
    @Override
    public List<Employee> showEmployee() {
       return employeeRepository.showEmployee();
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee( id );
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee( employee );
    }

    @Override
    public List<Employee> findEmployee(String search) {
        return employeeRepository.findEmployeeByString( search );
    }

    @Override
    public void editEmployee(Employee employee) {
        employeeRepository.editEmployee( employee );
    }

    @Override
    public Employee findEmployeeById(Integer id) {
       return employeeRepository.findEmployeeById( id );
    }

    @Override
    public List<String> checkValidateEmployee(String phone, String cardId, String email,String salary) {
        List<String> errEmployee = new ArrayList<>(  );
        if (!regex.checkPhoneNumber( phone )){
            errEmployee.add( " Phone number must be in the format 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx" );
        }else {
            errEmployee.add( "" );
        }
        if (!regex.checkIdCard( cardId )){
            errEmployee.add( "The ID number must be in the correct format XXXXXXXXX or XXXXXXXXXXXX (X number is 0-9)" );
        }else {
            errEmployee.add( "" );
        }
        if (!regex.checkEmail( email )){
            errEmployee.add( "Incorrect email format !" );
        }else {
            errEmployee.add("");
        }
        if (!regex.checkNumberDouble( salary )){
            errEmployee.add( "The salary must be greater than 0" );
        }else {
            errEmployee.add("");
        }
        return errEmployee;
    }

    @Override
    public boolean checkValidateEmployeeInService(String phone, String cardId, String email, String salary) {
        return (regex.checkPhoneNumber( phone )&&regex.checkIdCard( cardId )&&regex.checkEmail( email )&&
                regex.checkNumberDouble( salary ));
    }
}
