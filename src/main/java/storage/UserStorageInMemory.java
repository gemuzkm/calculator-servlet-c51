package storage;

import entity.User;

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
        if (getByUserLogin(user.getLogin()) == null) {
            listUser.add(user);
        } else {
            User oldUser = getByUserLogin(user.getLogin());
            delUser(oldUser);
            addUser(user);
        }
    }

    @Override
    public void delUser(User user) {
        HistoryStorageInMemory historyStorageInMemory = HistoryStorageInMemory.getInstance();

        listUser.remove(user);
        historyStorageInMemory.del(user.getLogin());
    }

    @Override
    public void delUser(String userLogin) {
        HistoryStorageInMemory historyStorageInMemory = HistoryStorageInMemory.getInstance();

        listUser.remove(getByUserLogin(userLogin));
        historyStorageInMemory.del(userLogin);
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

    @Override
    public ArrayList<User> getListUser() {
        return listUser;
    }
}
