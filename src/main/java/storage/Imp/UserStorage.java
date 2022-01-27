package storage.Imp;

import entity.User;

public interface UserStorage {

    void addUser(User user);
    User getByUserLogin(String userLogin);

}
