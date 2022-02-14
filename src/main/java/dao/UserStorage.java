package dao;

import entity.User;

import java.util.List;

public interface UserStorage<T extends User, K> {

    void addUser(T user);
    User getUserByLogin(K userLogin);
    void delUser(T user);
    void delUser(K userLogin);
    List<T> getListUser();
}
