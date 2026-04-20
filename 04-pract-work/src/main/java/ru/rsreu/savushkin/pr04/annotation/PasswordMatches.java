package ru.rsreu.savushkin.pr04.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ru.rsreu.savushkin.pr04.validator.PasswordMatchesValidator;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented
public @interface PasswordMatches {
    String message() default "Пароли не совпадают";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
