package com.example.annotation.customer;

import com.example.validation.customer.BirthdayCustomerValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BirthdayCustomerValidation.class)
@Documented
public @interface BirthdayCustomer {
    String message() default "Your age is not enough to register !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
