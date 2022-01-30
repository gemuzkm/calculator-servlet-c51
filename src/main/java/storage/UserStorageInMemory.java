package storage;

import entity.User;
import storage.Imp.UserStorage;

import java.util.ArrayList;

public class UserStorageInMemory implements UserStorage {

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

    @Override
    public void addUser(User user) {
        listUser.add(user);
    }

    @Override
    public void delUser(User user) {
        listUser.remove(user);
    }

    @Override
    public void delUser(String userLogin) {
        listUser.remove(userLogin);
    }

    @Override
    public User getByUserLogin(String userLogin) {
        for (User user : listUser) {
            if (user.getLogin().equals(userLogin)) {
                return user;
            }
        }
        return null;
    }
}
