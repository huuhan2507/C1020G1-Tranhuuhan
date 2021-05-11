package repository;

import bean.customer.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> showCustomer();
    void deleteCustomer(int id);
    List<Customer> searchCustomer(String search);
    Customer searchCustomerById(int id);
    void updateCustomer(Customer customer);
    void createCustomer(Customer customer);
}
