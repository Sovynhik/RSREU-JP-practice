package ru.rsreu.sovynhik;

import ru.rsreu.sovynhik.models.Auto;
import ru.rsreu.sovynhik.models.User;
import ru.rsreu.sovynhik.service.UserService;

public class Task2 {
    public static void main(String[] args) {
        UserService userService = new UserService();

        User user = new User("Masha", 26);
        userService.saveUser(user);

        Auto ferrari = new Auto("Ferrari", "red");
        user.addAuto(ferrari);

        Auto ford = new Auto("Ford", "black");
        user.addAuto(ford);

        userService.updateUser(user);

        user.setName("Sasha");
        User managedUser = userService.findUser(user.getId());
        managedUser.setName("Sasha");
        userService.updateUser(managedUser);

        System.out.println("Task #2. Complete! Check tables.");
    }
}