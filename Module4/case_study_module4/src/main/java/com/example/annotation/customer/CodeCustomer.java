package com.example.annotation.customer;

import com.example.validation.customer.CodeCustomerValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CodeCustomerValidation.class)
@Documented
public @interface CodeCustomer {
    String message() default "Customer code already exists, please enter another code !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
