package storage;

import entity.User;

import java.util.List;

public interface UserStorage {

    void addUser(User user);
    User getByUserLogin(String userLogin);
    void delUser(User user);
    void delUser(String userLogin);
    List<User> getListUser();

}
