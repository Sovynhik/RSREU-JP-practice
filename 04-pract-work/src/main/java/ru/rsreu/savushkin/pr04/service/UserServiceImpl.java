package ru.rsreu.savushkin.pr04.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rsreu.savushkin.pr04.dto.UserDto;
import ru.rsreu.savushkin.pr04.exception.EmailExistsException;
import ru.rsreu.savushkin.pr04.model.User;
import ru.rsreu.savushkin.pr04.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User registerNewUserAccount(UserDto userDto) throws EmailExistsException {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new EmailExistsException("Пользователь с таким email уже существует" + userDto.getEmail());
        }

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

        user.setPassword(userDto.getPassword());

        return userRepository.save(user);
    }
}
