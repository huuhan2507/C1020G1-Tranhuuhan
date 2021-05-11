package com.example.annotation.customer;

import com.example.validation.customer.EmailDuplicateCustomerValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailDuplicateCustomerValidation.class)
@Documented
public @interface EmailDuplicateCustomer {
    String message() default "Customer email already exists, please enter another email !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
