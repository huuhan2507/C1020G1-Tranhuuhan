package com.example.annotation.employee;

import com.example.validation.employee.BirthdayEmployeeValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BirthdayEmployeeValidation.class)
@Documented
public @interface BirthdayEmployee {
    String message() default "Your age is not enough to working !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
