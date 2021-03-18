package com.example.validation.customer;

import com.example.annotation.customer.EmailDuplicateCustomer;
import com.example.entity.customer.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EmailDuplicateCustomerValidation implements ConstraintValidator<EmailDuplicateCustomer, String> {
   public static String emailCustomer;
   @Autowired
   CustomerService customerService;
   public void initialize(EmailDuplicateCustomer constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
         List<Customer> customers = customerService.findAll();
         for (Customer c : customers) {
            if (obj.equals( c.getCustomerEmail() )) {
               return obj.equals( emailCustomer );
            }
         }
         return true;
   }
}
