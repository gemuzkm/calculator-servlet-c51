package service;

import entity.Operation;

import java.util.List;
import java.util.ListIterator;

public class ValueListHandler implements ValueListIterator<Operation> {

    private List<Operation>  list;
    private ListIterator<Operation> listIterator;

    @Override
    public int getSize() {
       return list != null ? list.size() : 0;
    }

    @Override
    public Operation getCurrentElement() {
        return null;
    }

    @Override
    public List<Operation> getPreviousElements(int count) {
        return null;
    }

    @Override
    public List<Operation> getNextElements(int count) {
        return null;
    }

    @Override
    public void resetIndex() {
        if (listIterator != null) {
            listIterator = list.listIterator();
        }
    }
}
