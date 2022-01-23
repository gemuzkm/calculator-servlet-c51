package storage;

import entity.User;

import java.util.ArrayList;

public class UserStorageInMemory {

    private final static ArrayList<User> listUser = new ArrayList<>();

    public void addUser(User user) {
        listUser.add(user);
    }

    public User getByUserLogin(String userLogin) {
        for (User user : listUser) {
            if (user.getName().equals(userLogin)) {
                return user;
            }
        }
        return null;
    }
}
