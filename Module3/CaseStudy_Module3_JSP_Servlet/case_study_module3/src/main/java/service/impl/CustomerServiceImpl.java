package service.impl;

import bean.customer.Customer;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;
import service.checkvalidate.Regex;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();
    Regex regex = new Regex();

    @Override
    public List<Customer> showCustomer() {
        return customerRepository.showCustomer();
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteCustomer( id );
    }

    @Override
    public List<Customer> searchCustomer(String search) {
        return customerRepository.searchCustomer( search );
    }

    @Override
    public Customer searchCustomerById(int id) {
        return customerRepository.searchCustomerById( id );
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer( customer );
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.createCustomer( customer );
    }

    @Override
    public List<String> validateCustomer(String cardId, String phone, String email) {
        List<String> errCustomer = new ArrayList<>();
        if (!regex.checkPhoneNumber( phone )) {
            errCustomer.add( " Phone number must be in the format 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx" );
        } else {
            errCustomer.add( "" );
        }
        if (!regex.checkIdCard( cardId )) {
            errCustomer.add( "The ID number must be in the correct format XXXXXXXXX or XXXXXXXXXXXX (X number is 0-9)" );
        } else {
            errCustomer.add( "" );
        }
        if (!regex.checkEmail( email )) {
            errCustomer.add( "Incorrect email format !" );
        } else {
            errCustomer.add( "" );
        }
        return errCustomer;
    }

    public boolean validateCustomerInService(String cardId, String phone, String email) {
        return (regex.checkPhoneNumber( phone ) && regex.checkIdCard( cardId ) && regex.checkEmail( email ));
    }

    public String dateOfSQL(String input) {
        String[] dateArray = input.split( "/" );
        return dateArray[2] + "-" + dateArray[1] + "-" + dateArray[0];
    }
}
