package ru.rsreu.savushkin.pr04.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ru.rsreu.savushkin.pr04.dto.UserDto;
import ru.rsreu.savushkin.pr04.exception.EmailExistsException;
import ru.rsreu.savushkin.pr04.service.UserService;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/user/registration")
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto,
                                            BindingResult result,
                                            WebRequest request) {
        if (result.hasErrors()) {
            return new ModelAndView("registration", "user", userDto);
        }

        try {
            userService.registerNewUserAccount(userDto);
        } catch (EmailExistsException e) {
            result.rejectValue("email", "userDto.email", "Пользователь с таким email уже существует");
            return new ModelAndView("registration", "user", userDto);
        }

        return new ModelAndView("redirect:/login");
    }
}
