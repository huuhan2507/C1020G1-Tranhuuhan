package com.example.validation.employee;

import com.example.annotation.employee.EmailDuplicateEmployee;
import com.example.entity.customer.Customer;
import com.example.entity.employee.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EmailEmployeeValidation implements ConstraintValidator<EmailDuplicateEmployee, String> {
   public static String emailCustomer;
   @Autowired
   private EmployeeService employeeService;
   public void initialize(EmailDuplicateEmployee constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      List<Employee> employees = employeeService.findAll();
      for (Employee e : employees) {
         if (obj.equals( e.getEmployeeEmail() )) {
            return obj.equals( emailCustomer );
         }
      }
      return true;
   }
}
