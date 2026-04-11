package ru.rsreu.savushkin.pr01;

import ru.rsreu.savushkin.pr01.models.Auto;
import ru.rsreu.savushkin.pr01.models.User;
import ru.rsreu.savushkin.pr01.services.UserService;

public class Task3 {
    public static void main(String[] args) {

        UserService userService = new UserService();
        User user = new User("Masha",26);
        userService.saveUser(user);
        Auto ferrari = new Auto("Ferrari", "red");
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford", "black");
        ford.setUser(user);
        user.addAuto(ford);
        userService.updateUser(user);
        user.setName("Sasha");
        userService.updateUser(user);
        userService.deleteUser(user);
    }
}
