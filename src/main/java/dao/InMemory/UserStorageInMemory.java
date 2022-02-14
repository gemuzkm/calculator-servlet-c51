package dao.InMemory;

import entity.User;
import dao.UserStorage;

import java.util.ArrayList;
import java.util.List;

public class UserStorageInMemory implements UserStorage<User, String> {

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
        if (getUserByLogin(user.getLogin()) == null) {
            listUser.add(user);
        } else {
            User oldUser = getUserByLogin(user.getLogin());
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

        listUser.remove(getUserByLogin(userLogin));
        historyStorageInMemory.del(userLogin);
    }

    @Override
    public User getUserByLogin(String userLogin) {
        for (User user : listUser) {
            if (user.getLogin().equals(userLogin)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getListUser() {
        return listUser;
    }
}
