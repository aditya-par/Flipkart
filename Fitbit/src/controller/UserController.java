package controller;

import model.Location;
import service.UserService;

public class UserController {

    UserService userService = new UserService();

    public void addUser(String name, Integer age, String city) {
        userService.registerUser(name, age, city);
    }

}
