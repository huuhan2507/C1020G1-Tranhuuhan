package service;

import bean.customer.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> showCustomer();
    void deleteCustomer(int id);
    List<Customer> searchCustomer(String search);
    Customer searchCustomerById(int id);
    void updateCustomer(Customer customer);
    void createCustomer(Customer customer);
    List<String> validateCustomer( String cardId,String phone , String email);
    public boolean validateCustomerInService( String cardId, String phone, String email);

}
