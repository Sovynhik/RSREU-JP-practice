package ru.rsreu.savushkin.pr04.service;

import ru.rsreu.savushkin.pr04.dto.UserDto;
import ru.rsreu.savushkin.pr04.exception.EmailExistsException;
import ru.rsreu.savushkin.pr04.model.User;

public interface UserService {
    User registerNewUserAccount(UserDto userDto) throws EmailExistsException;
}
