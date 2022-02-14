package service;

import entity.User;

import java.util.List;

public class StoreListHandler implements ValueListIterator<User> {



    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public User getCurrentElement() {
        return null;
    }

    @Override
    public List<User> getPreviousElements(int count) {
        return null;
    }

    @Override
    public List<User> getNextElements(int count) {
        return null;
    }

    @Override
    public void resetIndex() {

    }
}
