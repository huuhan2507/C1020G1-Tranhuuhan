package com.example.validation.customer;

import com.example.annotation.customer.BirthdayCustomer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class BirthdayCustomerValidation implements ConstraintValidator<BirthdayCustomer, String> {
   public void initialize(BirthdayCustomer constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
         Date now = new Date();
         int day = now.getDate();
         int month = now.getMonth() + 1;
         int year = now.getYear() + 1900;
         int yearCus = Integer.parseInt( obj.substring( 0, 4 ) );
         int monthCus = Integer.parseInt( obj.substring( 5, 7 ) );
         int dayCus = Integer.parseInt( obj.substring( 8, 10 ) );
         if ((year - yearCus) > 18) {
            return true;
         }
         if (year - yearCus == 18) {
            if (month - monthCus > 0) {
               return true;
            } else if (month == monthCus) {
               return day - dayCus > 0;
            }
         }
         return false;
   }
}
