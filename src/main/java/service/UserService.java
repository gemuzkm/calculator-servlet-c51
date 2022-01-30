package service;

import entity.User;
import storage.UserStorageInMemory;
import validator.UserValidator;

import java.util.ArrayList;

public class UserService {
    private UserStorageInMemory userStorageInMemory =  UserStorageInMemory.getInstance();
    private UserValidator userValidator = new UserValidator();
    private CalculatorService calculatorService = new CalculatorService();

    public User getByUserLogin(String userLogin) {
        return userStorageInMemory.getByUserLogin(userLogin);
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
        userStorageInMemory.addUser(user);
    }

    public void delUser(User user) {
        userStorageInMemory.delUser(user);
    }

    public ArrayList<User> getListUser() {
        return userStorageInMemory.getListUser();
    }
}
