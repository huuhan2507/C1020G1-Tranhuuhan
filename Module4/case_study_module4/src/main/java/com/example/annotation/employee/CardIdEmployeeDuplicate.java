package com.example.annotation.employee;

import com.example.validation.customer.CardDuplicateCustomerValidation;
import com.example.validation.employee.CardIdDuplicateEmployeeValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CardIdDuplicateEmployeeValidation.class)
@Documented
public @interface CardIdEmployeeDuplicate {
    String message() default "Employee card id already exists, please enter another card id !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
