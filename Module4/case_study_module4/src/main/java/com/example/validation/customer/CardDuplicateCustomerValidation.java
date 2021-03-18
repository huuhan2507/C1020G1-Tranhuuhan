package com.example.validation.customer;

import com.example.annotation.customer.CardIdDuplicateCustomer;
import com.example.entity.customer.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CardDuplicateCustomerValidation implements ConstraintValidator<CardIdDuplicateCustomer, String> {
   public static String cardIdCustomer;
   @Autowired
   private CustomerService customerService;
   public void initialize(CardIdDuplicateCustomer constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      List<Customer> customers = customerService.findAll();
      for (Customer c : customers) {
         if (obj.equals( c.getCustomerCardId())) {
            return obj.equals( cardIdCustomer );
         }
      }
      return true;
   }
}
