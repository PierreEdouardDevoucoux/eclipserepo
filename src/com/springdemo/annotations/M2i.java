package com.springdemo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.springdemo.validators.CodePromoValidator;

@Constraint(validatedBy=CodePromoValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface M2i {
	public String value() default "m2i2020";
	public String message() default "doit commencer par m2i";
	Class<?>[] groups() default {}; 
	Class<? extends Payload>[] payload() default{}; 
}
