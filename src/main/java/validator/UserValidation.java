package validator;

import entity.User;
import storage.UserStorageInMemory;

public class UserValidation {
    UserStorageInMemory userStorageInMemory = new UserStorageInMemory();

    public boolean existsUser(User user) {
        if (userStorageInMemory.getByUserLogin(user.getLogin()) != null) {
            return true;
        } else {
            return false;
        }
    }
}
