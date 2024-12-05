package repository;

import model.User;

public interface UserRepository {

    void addUser(User user);

    User getUser(Long userId);

}
