package dao;

import entity.User;

import java.util.List;

public interface UserStorage {

    void addUser(User user);
    User getUserByLogin(String userLogin);
    void delUser(User user);
    void delUser(String userLogin);
    List<User> getListUser();

}
