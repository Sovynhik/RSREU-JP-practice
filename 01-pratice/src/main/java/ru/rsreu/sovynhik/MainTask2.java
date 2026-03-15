package ru.rsreu.sovynhik;

import ru.rsreu.sovynhik.models.Auto;
import ru.rsreu.sovynhik.models.User;
import ru.rsreu.sovynhik.service.UserService;
import ru.rsreu.sovynhik.utils.DatabaseCleaner;

public class MainTask2 {
    public static void main(String[] args) {
        DatabaseCleaner.clearAllTables();

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

        System.out.println("Задание 2. Готово! Проверьте таблицы.");
    }
}