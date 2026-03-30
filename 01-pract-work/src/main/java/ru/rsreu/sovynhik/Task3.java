package ru.rsreu.sovynhik;

import ru.rsreu.sovynhik.models.Auto;
import ru.rsreu.sovynhik.models.User;
import ru.rsreu.sovynhik.service.UserService;

public class Task3 {
    public static void main(String[] args) {
        UserService userService = new UserService();

        User user = new User("Masha", 26);
        userService.saveUser(user);

        Auto ferrari = new Auto("Ferrari", "red");
        user.addAuto(ferrari);

        Auto ford = new Auto("Ford", "black");
        user.addAuto(ford);

        userService.updateUser(user);

        System.out.println("Авто добавлены. User id = " + user.getId());

        user.setName("Sasha");
        User managedUser = userService.findUser(user.getId());
        managedUser.setName("Sasha");
        userService.updateUser(managedUser);

        userService.deleteUser(managedUser);

        System.out.println("Task #3. Complete! Check tables.");
    }
}