package com.example.validation.employee;

import com.example.annotation.employee.CardIdEmployeeDuplicate;
import com.example.entity.employee.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CardIdDuplicateEmployeeValidation implements ConstraintValidator<CardIdEmployeeDuplicate, String> {
   public static String cardIdEmployee;
   @Autowired
   private EmployeeService employeeService;
   public void initialize(CardIdEmployeeDuplicate constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
         List<Employee> employees = employeeService.findAll();
         for (Employee e : employees) {
            if (obj.equals( e.getEmployeeCardId() )) {
               return obj.equals( cardIdEmployee );
            }
         }
         return true;
   }
}
