package com.casacodigo.hernani.beanscustomizado;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = { IdValidoValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface IdValido {

	String message() default "Id invalido ";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
	String fieldName();
	
	Class<?> domainClass();

}
