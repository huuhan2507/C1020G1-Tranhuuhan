package repository.impl;

import bean.employee.Employee;
import repository.EmployeeRepository;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    public static final String SHOW_EMPLOYEE = "select * from employee";
    public static final String DELETE_EMPLOYEE = "delete from employee where employee_id=?";
    public static final String CREATE_EMPLOYEE = "call create_employee(?,?,?,?,?,?,?,?,?,?,?)";
    public static final String ONE_EMPLOYEE = "select * from employee where employee_id=?";
    public static final String UPDATE_EMPLOYEE = "call update_employee(?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String SEARCH_EMPLOYEE = "select * from employee where employee_name like concat('%',?,'%')";

    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Employee> showEmployee() {
        List<Employee> employeeList = new ArrayList<>( );
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement( SHOW_EMPLOYEE );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employee employee = new Employee(  );
                employee.setEmployeeId( Integer.parseInt( resultSet.getString( 1 )  ));
                employee.setEmployeeName( resultSet.getString( 2 ) );
                employee.setEmployeeBirthDay( resultSet.getString( 3 ) );
                employee.setEmployeeIdCard( resultSet.getString( 4 ) );
                employee.setEmployeeSalary( Double.parseDouble( resultSet.getString( 5 ) ) );
                employee.setEmployeePhone( resultSet.getString( 6 ) );
                employee.setEmployeeEmail( resultSet.getString( 7 ) );
                employee.setEmployeeAddress( resultSet.getString( 8 ) );
                employee.setPositionId( resultSet.getInt( 9 ) );
                employee.setEducationDegreeId( resultSet.getInt( 10 ) );
                employee.setDivisionId( resultSet.getInt( 11 ) );
                employee.setUserName( resultSet.getString( 12 ) );
                employeeList.add( employee );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void deleteEmployee(int id) {
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement( DELETE_EMPLOYEE );
            preparedStatement.setString( 1,String.valueOf( id ) );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        try {
            CallableStatement callableStatement =baseRepository.getConnection().prepareCall( CREATE_EMPLOYEE  );
            callableStatement.setString( 1,employee.getEmployeeName() );
            callableStatement.setString( 2,employee.getEmployeeBirthDay());
            callableStatement.setString( 3,employee.getEmployeeIdCard() );
            callableStatement.setDouble( 4,employee.getEmployeeSalary());
            callableStatement.setString( 5,employee.getEmployeePhone() );
            callableStatement.setString( 6,employee.getEmployeeEmail() );
            callableStatement.setString( 7,employee.getEmployeeAddress() );
            callableStatement.setInt( 8,employee.getPositionId() );
            callableStatement.setInt( 9,employee.getEducationDegreeId() );
            callableStatement.setInt( 10,employee.getDivisionId() );
            callableStatement.setString( 11,employee.getUserName() );
            callableStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> findEmployeeByString(String search) {
        List<Employee> employeeList = new ArrayList<>(  );
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement( SEARCH_EMPLOYEE );
            preparedStatement.setString( 1,search );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employee employee = new Employee( );
                employee.setEmployeeId( Integer.parseInt( resultSet.getString( 1 )  ));
                employee.setEmployeeName( resultSet.getString( 2 ) );
                employee.setEmployeeBirthDay( resultSet.getString( 3 ) );
                employee.setEmployeeIdCard( resultSet.getString( 4 ) );
                employee.setEmployeeSalary( Double.parseDouble( resultSet.getString( 5 ) ) );
                employee.setEmployeePhone( resultSet.getString( 6 ) );
                employee.setEmployeeEmail( resultSet.getString( 7 ) );
                employee.setEmployeeAddress( resultSet.getString( 8 ) );
                employee.setPositionId( resultSet.getInt( 9 ) );
                employee.setEducationDegreeId( resultSet.getInt( 10 ) );
                employee.setDivisionId( resultSet.getInt( 11 ) );
                employee.setUserName( resultSet.getString( 12 ) );
                employeeList.add( employee );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void editEmployee(Employee employee) {
        try {
            CallableStatement callableStatement = baseRepository.getConnection().prepareCall( UPDATE_EMPLOYEE );
            callableStatement.setString( 1,String.valueOf( employee.getEmployeeId()  ));
            callableStatement.setString( 2,employee.getEmployeeName() );
            callableStatement.setString( 3,employee.getEmployeeBirthDay() );
            callableStatement.setString( 4,employee.getEmployeeIdCard() );
            callableStatement.setString( 5,String.valueOf( employee.getEmployeeSalary() ) );
            callableStatement.setString( 6,employee.getEmployeePhone() );
            callableStatement.setString( 7,employee.getEmployeeEmail() );
            callableStatement.setString( 8,employee.getEmployeeAddress() );
            callableStatement.setString( 9,String.valueOf(  employee.getPositionId()) );
            callableStatement.setString( 10,String.valueOf( employee.getEducationDegreeId() ) );
            callableStatement.setString( 11,String.valueOf( employee.getDivisionId() ) );
            callableStatement.setString( 12,employee.getUserName() );
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement( ONE_EMPLOYEE );
            preparedStatement.setString( 1,String.valueOf( id ) );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                employee = new Employee(  );
                employee.setEmployeeId( resultSet.getInt( 1 ) );
                employee.setEmployeeName( resultSet.getString( 2 ) );
                employee.setEmployeeBirthDay( resultSet.getString( 3 ) );
                employee.setEmployeeIdCard( resultSet.getString( 4 ) );
                employee.setEmployeeSalary( resultSet.getDouble( 5 ) );
                employee.setEmployeePhone( resultSet.getString( 6 ) );
                employee.setEmployeeEmail( resultSet.getString( 7 ) );
                employee.setEmployeeAddress( resultSet.getString( 8 ) );
                employee.setPositionId( resultSet.getInt( 9 ) );
                employee.setEducationDegreeId( resultSet.getInt( 10 ) );
                employee.setDivisionId( resultSet.getInt( 11 ) );
                employee.setUserName( resultSet.getString( 12 ) );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
