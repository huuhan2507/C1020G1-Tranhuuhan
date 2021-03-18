package com.example.annotation.customer;


import com.example.validation.customer.CardDuplicateCustomerValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CardDuplicateCustomerValidation.class)
@Documented
public @interface CardIdDuplicateCustomer {
    String message() default "Customer card id already exists, please enter another card id !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
