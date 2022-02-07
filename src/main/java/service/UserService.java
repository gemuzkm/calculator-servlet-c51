package service;

import entity.User;
import storage.InMemory.UserStorageInMemory;
import storage.JDBC.UserStorageJDBC;
import web.validator.UserValidator;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserStorageInMemory userStorageInMemory =  UserStorageInMemory.getInstance();
    private UserStorageJDBC userStorageJDBC = UserStorageJDBC.getInstance();
    private UserValidator userValidator = new UserValidator();
    private CalculatorService calculatorService = new CalculatorService();

    public User getByUserLogin(String userLogin) {
        return userStorageJDBC.getByUserLogin(userLogin);
    }

    public void deleteHistoryAfterIdChange(String userLogin, String sessionID) {
        if(userValidator.changedUserSessionID(userLogin, sessionID)) {
            calculatorService.delHistory(userLogin);
        }
    }

    public boolean changedUserSessionID(String userLogin, String sessionID) {
        return userValidator.changedUserSessionID(userLogin, sessionID);
    }

    public void addUser(User user) {
        userStorageJDBC.addUser(user);
    }

    public void delUser(User user) {
        userStorageJDBC.delUser(user);
    }

    public List<User> getListUser() {
        return userStorageJDBC.getListUser();
    }
}
