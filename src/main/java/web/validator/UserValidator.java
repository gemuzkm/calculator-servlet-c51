package web.validator;

import entity.User;
import storage.InMemory.UserStorageInMemory;
import storage.JDBC.UserStorageJDBC;

public class UserValidator {
    private UserStorageInMemory userStorageInMemory = UserStorageInMemory.getInstance();
    private UserStorageJDBC userStorageJDBC = UserStorageJDBC.getInstance();

    public boolean existsUser(User user) {
        if (userStorageJDBC.getByUserLogin(user.getLogin()) != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean existsUser(String userLogin) {
        if (userStorageJDBC.getByUserLogin(userLogin) != null) {
            return true;
        } else {
            return false;
        }
    }

    public User validUserPassword(String userLogin, String userPassword) {
        User user = userStorageJDBC.getByUserLogin(userLogin);
        if (user.getPassword().equals(userPassword)) {
            return user;
        }
        return null;
    }

    public boolean changedUserSessionID(String userLogin, String sessionID) {
        User user = userStorageJDBC.getByUserLogin(userLogin);
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
