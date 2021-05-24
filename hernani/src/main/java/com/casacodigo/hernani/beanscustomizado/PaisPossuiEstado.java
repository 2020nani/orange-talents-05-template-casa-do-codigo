package com.casacodigo.hernani.beanscustomizado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {PaisPossuiEstadoValidator.class})
@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PaisPossuiEstado {
    String message() default "Este país nao possui Estado cadastrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
