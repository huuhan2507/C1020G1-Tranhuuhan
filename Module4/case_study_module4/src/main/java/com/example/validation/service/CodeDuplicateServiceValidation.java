package com.example.validation.service;

import com.example.annotation.service.CodeDuplicateService;
import com.example.entity.employee.Employee;
import com.example.entity.service.Service;
import com.example.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CodeDuplicateServiceValidation implements ConstraintValidator<CodeDuplicateService, String> {
   public static String codeService;
   @Autowired
   private ServiceService serviceService;
   public void initialize(CodeDuplicateService constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      List<Service> services = serviceService.findAll();
      for (Service s : services) {
         if (obj.equals( s.getServiceCode() )) {
            return obj.equals( codeService );
         }
      }
      return true;
   }
}
