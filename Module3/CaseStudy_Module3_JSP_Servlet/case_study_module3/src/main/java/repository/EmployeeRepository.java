package repository;

import bean.employee.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> showEmployee();
    void deleteEmployee(int id);
    void addEmployee(Employee employee);
    List<Employee> findEmployeeByString(String search);
    void editEmployee(Employee employee);
    Employee findEmployeeById(Integer id);
}

