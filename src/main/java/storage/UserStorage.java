package storage;

import entity.User;

import java.util.ArrayList;

public class UserStorage {

    private final ArrayList<User> listUser = new ArrayList<>();

    public void addUser(User user) {
        listUser.add(user);
    }

    public User getByUser(String userName) {
        for (User user : listUser) {
            if (user.equals(userName)) {
                return user;
            }
        }
        return null;
    }
}
