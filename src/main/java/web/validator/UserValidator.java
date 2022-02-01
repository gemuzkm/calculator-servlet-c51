package web.validator;

import entity.User;
import storage.UserStorageInMemory;

public class UserValidator {
    UserStorageInMemory userStorageInMemory = UserStorageInMemory.getInstance();

    public boolean existsUser(User user) {
        if (userStorageInMemory.getByUserLogin(user.getLogin()) != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean existsUser(String userLogin) {
        if (userStorageInMemory.getByUserLogin(userLogin) != null) {
            return true;
        } else {
            return false;
        }
    }

    public User validUserPassword(String userLogin, String userPassword) {
        User user = userStorageInMemory.getByUserLogin(userLogin);
        if (user.getPassword().equals(userPassword)) {
            return user;
        }
        return null;
    }

    public boolean changedUserSessionID(String userLogin, String sessionID) {
        User user = userStorageInMemory.getByUserLogin(userLogin);
        if (user.getSessionID().equals(sessionID)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validUserRole(String userRole) {
        if (userRole.equals("0") || userRole.equals("1")) {
            return true;
        } else {
            return false;
        }
    }
}
