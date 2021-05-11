package service;

import bean.employee.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> showEmployee();

    void deleteEmployee(int id);

    void addEmployee(Employee employee);

    List<Employee> findEmployee(String search);

    void editEmployee(Employee employee);

    Employee findEmployeeById(Integer id);

    List<String> checkValidateEmployee(String phone, String cardId, String email,String salary);

    boolean checkValidateEmployeeInService(String phone, String cardId, String email,String salary);
}
