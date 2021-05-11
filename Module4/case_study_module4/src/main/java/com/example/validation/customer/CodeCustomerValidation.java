package com.example.validation.customer;

import com.example.annotation.customer.CodeCustomer;
import com.example.entity.customer.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CodeCustomerValidation implements ConstraintValidator<CodeCustomer, String> {
   public static String codeCustomer;
   @Autowired
   private CustomerService customerService;
   public void initialize(CodeCustomer constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
         List<Customer> customers = customerService.findAll();
         for (Customer c : customers) {
            if (obj.equals( c.getCustomerCode() )) {
               return obj.equals( codeCustomer );
            }
         }
         return true;
   }
}
