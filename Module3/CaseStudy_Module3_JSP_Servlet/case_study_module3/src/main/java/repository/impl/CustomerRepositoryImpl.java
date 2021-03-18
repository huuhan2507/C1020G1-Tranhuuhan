package repository.impl;

import bean.customer.Customer;
import bean.customer.CustomerType;
import repository.CustomerRepository;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    public static final String SHOW_CUSTOMER = "select *from customer c\n" +
            "inner join customer_type t on t.customer_type_id=c.customer_type_id";
    public static final String DELETE_CUSTOMER=" delete from customer where customer_id=?";
    public static final String CREATE_CUSTOMER = "call create_customer(?,?,?,?,?,?,?,?)";
    public static final String ONE_CUSTOMER ="select *from customer c\n" +
            "inner join customer_type t on t.customer_type_id=c.customer_type_id where c.customer_id=?";
    public static final String UPDATE_CUSTOMER = "call update_customer(?,?,?,?,?,?,?,?,?)";
    public static final String SEARCH_CUSTOMER = "select *from customer c\n" +
            "inner join customer_type t on t.customer_type_id=c.customer_type_id where c.customer_name like concat('%',?,'%')";

    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Customer> showCustomer() {
        List<Customer> customerList = new ArrayList<>(  );
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement( SHOW_CUSTOMER );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Customer customer = new Customer(  );
                customer.setCustomerId( resultSet.getInt( 1 ) );
                customer.setCustomerType( new CustomerType( resultSet.getInt( 2 ),resultSet.getString( 11 ) ) );
                customer.setCustomerName( resultSet.getString( 3 ) );
                customer.setCustomerBirthday( resultSet.getString( 4 ) );
                customer.setCustomerGender( resultSet.getString( 5 ) );
                customer.setCustomerIdCard( resultSet.getString( 6 ) );
                customer.setCustomerPhone( resultSet.getString( 7 ) );
                customer.setCustomerEmail( resultSet.getString( 8 ) );
                customer.setCustomerAddress( resultSet.getString( 9 ) );
                customerList.add( customer );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void deleteCustomer(int id) {
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement( DELETE_CUSTOMER );
            preparedStatement.setString( 1,String.valueOf( id ) );
            preparedStatement.executeUpdate( );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> searchCustomer(String search) {
        List<Customer> customerList = new ArrayList<>(  );
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement( SEARCH_CUSTOMER );
            preparedStatement.setString( 1,search );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Customer customer = new Customer(  );
                customer.setCustomerId( resultSet.getInt( 1 ) );
                customer.setCustomerType( new CustomerType( resultSet.getInt( 2 ),resultSet.getString( 11 ) ) );
                customer.setCustomerName( resultSet.getString( 3 ) );
                customer.setCustomerBirthday( resultSet.getString( 4 ) );
                customer.setCustomerGender( resultSet.getString( 5 ) );
                customer.setCustomerIdCard( resultSet.getString( 6 ) );
                customer.setCustomerPhone( resultSet.getString( 7 ) );
                customer.setCustomerEmail( resultSet.getString( 8 ) );
                customer.setCustomerAddress( resultSet.getString( 9 ) );
                customerList.add( customer );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer searchCustomerById(int id) {
        Customer customer = new Customer(  );
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement( ONE_CUSTOMER );
            preparedStatement.setString( 1,String.valueOf( id ) );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                customer.setCustomerId( resultSet.getInt( 1 ) );
                customer.setCustomerType( new CustomerType( resultSet.getInt( 2 ),resultSet.getString( 11 ) ) );
                customer.setCustomerName( resultSet.getString( 3 ) );
                customer.setCustomerBirthday( resultSet.getString( 4 ) );
                customer.setCustomerGender( resultSet.getString( 5 ) );
                customer.setCustomerIdCard( resultSet.getString( 6 ) );
                customer.setCustomerPhone( resultSet.getString( 7 ) );
                customer.setCustomerEmail( resultSet.getString( 8 ) );
                customer.setCustomerAddress( resultSet.getString( 9 ) );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        try {
            CallableStatement callableStatement = baseRepository.getConnection().prepareCall( UPDATE_CUSTOMER );
            callableStatement.setString( 1,String.valueOf( customer.getCustomerId() ) );
            callableStatement.setInt( 2,customer.getCustomerType().getCustomerTypeId() );
            callableStatement.setString( 3,customer.getCustomerName() );
            callableStatement.setString( 4,customer.getCustomerBirthday() );
            callableStatement.setString( 5,customer.getCustomerGender() );
            callableStatement.setString( 6,customer.getCustomerIdCard() );
            callableStatement.setString( 7,customer.getCustomerPhone() );
            callableStatement.setString( 8,customer.getCustomerEmail() );
            callableStatement.setString( 9,customer.getCustomerAddress() );
            callableStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void createCustomer(Customer customer) {
        try {
            CallableStatement callableStatement= baseRepository.getConnection().prepareCall( CREATE_CUSTOMER );
            callableStatement.setInt( 1,customer.getCustomerType().getCustomerTypeId() );
            callableStatement.setString( 2,customer.getCustomerName() );
            callableStatement.setString( 3,customer.getCustomerBirthday() );
            callableStatement.setString( 4,customer.getCustomerGender() );
            callableStatement.setString( 5,customer.getCustomerIdCard() );
            callableStatement.setString( 6,customer.getCustomerPhone() );
            callableStatement.setString( 7,customer.getCustomerEmail() );
            callableStatement.setString( 8,customer.getCustomerAddress() );
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
