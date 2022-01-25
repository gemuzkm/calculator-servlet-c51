package storage;

import entity.User;

import java.util.ArrayList;

public class UserStorageInMemory {

    private static UserStorageInMemory instance;

    private UserStorageInMemory() {
    }

    public static UserStorageInMemory getInstance() {
        if (instance == null) {
            instance = new UserStorageInMemory();
        }
        return instance;
    }

    private final static ArrayList<User> listUser = new ArrayList<>();

    public void addUser(User user) {
        listUser.add(user);
    }

    public User getByUserLogin(String userLogin) {
        for (User user : listUser) {
            if (user.getLogin().equals(userLogin)) {
                return user;
            }
        }
        return null;
    }
}
