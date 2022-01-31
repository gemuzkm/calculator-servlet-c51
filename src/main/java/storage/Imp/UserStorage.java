package storage.Imp;

import entity.User;

import java.util.ArrayList;

public interface UserStorage {

    void addUser(User user);
    User getByUserLogin(String userLogin);
    void delUser(User user);
    public void delUser(String userLogin);
    ArrayList<User> getListUser();

}
