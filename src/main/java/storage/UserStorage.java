package storage;

import entity.User;

import java.util.ArrayList;

public interface UserStorage {

    void addUser(User user);
    User getByUserLogin(String userLogin);
    void delUser(User user);
    void delUser(String userLogin);
    ArrayList<User> getListUser();

}
