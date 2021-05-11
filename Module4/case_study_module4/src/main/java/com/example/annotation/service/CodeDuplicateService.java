package com.example.annotation.service;

import com.example.validation.service.CodeDuplicateServiceValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CodeDuplicateServiceValidation.class)
@Documented
public @interface CodeDuplicateService {
    String message() default "Service code already exists, please enter another code !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
