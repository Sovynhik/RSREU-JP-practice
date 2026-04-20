package ru.rsreu.savushkin.pr04.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.rsreu.savushkin.pr04.annotation.PasswordMatches;
import ru.rsreu.savushkin.pr04.annotation.ValidEmail;

@Data
@PasswordMatches
public class UserDto {

    @NotNull(message = "Имя не может быть пустым")
    @NotEmpty(message = "Имя не может быть пустым")
    private String firstName;

    @NotNull(message = "Фамилия не может быть пустой")
    @NotEmpty(message = "Фамилия не может быть пустой")
    private String lastName;

    @NotNull(message = "Email не может быть пустым")
    @NotEmpty(message = "Email не может быть пустым")
    @ValidEmail
    private String email;

    @NotNull(message = "Пароль не может быть пустым")
    @NotEmpty(message = "Пароль не может быть пустым")
    private String password;

    private String matchingPassword;
}
