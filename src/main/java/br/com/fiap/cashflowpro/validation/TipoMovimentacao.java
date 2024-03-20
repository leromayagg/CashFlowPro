package br.com.fiap.cashflowpro.validation;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = TipoMovimentacaoValidator.class)
public @interface TipoMovimentacao {

    String message() default "{movimentacoa.tipo.invalido}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
