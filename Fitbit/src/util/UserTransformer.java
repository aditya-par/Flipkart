package util;

import model.Location;
import model.User;

public class UserTransformer {

    public static User createUser(String name, Integer age, String city) {
        return new User(name, age, city);
    }

}
