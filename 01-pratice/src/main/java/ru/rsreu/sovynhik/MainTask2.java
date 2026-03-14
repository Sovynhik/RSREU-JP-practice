package ru.rsreu.sovynhik;

import ru.rsreu.sovynhik.models.Auto;
import ru.rsreu.sovynhik.models.User;
import ru.rsreu.sovynhik.service.UserService;

public class MainTask1 {
    public static void main(String[] args) {
        UserService userService = new UserService();

        User user = new User("Masha", 26);
        userService.saveUser(user);

        Auto ferrari = new Auto("Ferrari", "red");
        ferrari.setUser(user);
        user.addAuto(ferrari);

        Auto ford = new Auto("Ford", "black");
        ford.setUser(user);
        user.addAuto(ford);

        userService.updateUser(user);

        System.out.println("Готово! Проверьте таблицы.");
    }
}