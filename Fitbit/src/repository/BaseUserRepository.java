package repository;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class BaseUserRepository implements UserRepository{

    private static Map<Long, User> userMap = new HashMap<>();

    public void addUser(User user) {
        userMap.putIfAbsent(user.getUserId(), user);
    }

    public User getUser(Long userId) {
        return userMap.getOrDefault(userId, null);
    }

}
