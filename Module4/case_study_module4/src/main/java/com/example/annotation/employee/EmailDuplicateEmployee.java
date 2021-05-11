package com.example.annotation.employee;

import com.example.validation.employee.EmailEmployeeValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailEmployeeValidation.class)
@Documented
public @interface EmailDuplicateEmployee {
    String message() default "Employee email already exists, please enter another email !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
