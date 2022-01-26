package service;

import entity.User;
import storage.UserStorageInMemory;
import validator.UserValidation;

public class UserService {
    private UserStorageInMemory userStorageInMemory =  UserStorageInMemory.getInstance();
    private UserValidation userValidation = new UserValidation();
    private CalculatorService calculatorService = new CalculatorService();

    public User getByUserLogin(String userLogin) {
        return userStorageInMemory.getByUserLogin(userLogin);
    }

    public void deleteHistoryAfterIdChange(String userLogin, String sessionID) {
        if(userValidation.changedUserSessionID(userLogin, sessionID)) {
            calculatorService.delHistory(userLogin);
        }
    }

    public boolean changedUserSessionID(String userLogin, String sessionID) {
        return userValidation.changedUserSessionID(userLogin, sessionID);
    }

    public void addUser(User user) {
        userStorageInMemory.addUser(user);
    }
}
