package service;

import model.Location;
import model.User;
import repository.BaseUserRepository;
import repository.UserRepository;
import util.UserTransformer;

public class UserService {

    UserRepository userRepository = new BaseUserRepository();

    public void registerUser(String name, Integer age, String city) {
        User user = UserTransformer.createUser(name, age, city);
        userRepository.addUser(user);
    }

    public User getUser(Long userId) {
        return userRepository.getUser(userId);
    }
}
