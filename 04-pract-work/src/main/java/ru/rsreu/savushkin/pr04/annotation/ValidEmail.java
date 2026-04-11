package ru.rsreu.savushkin.pr04.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ru.rsreu.savushkin.pr04.validator.EmailValidator;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface ValidEmail {
    String message() default "Неверный формат email";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
