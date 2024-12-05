package org.example.repository;

import org.example.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    static Map<String, User> userMap = new HashMap<>();

    public void addUser(User user) {
        userMap.put(user.getName(), user);
    }

    public User getUserByName(String name) {
        return userMap.get(name);
    }

    public void updateUser(User fetchedUser) {
        userMap.put(fetchedUser.getName(), fetchedUser);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }
}
