package service;

import dao.JDBC.HistoryStorageJDBC;
import entity.Operation;
import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ValueListHandler implements ValueListIterator<User, Operation> {

    private HistoryStorageJDBC historyStorageJDBC = HistoryStorageJDBC.getInstance();

    private List<Operation> listOperation = null;
    private ListIterator<Operation> listIterator = null;
    private int index;

    public ValueListHandler() {
    }

    @Override
    public void setListHandler(User user) {
        if (listIterator == null) {
            listOperation = historyStorageJDBC.getListHistoryOperation(user.getLogin());
        }

        if (listIterator == null) {
            listIterator = listOperation.listIterator();
        }

    }

    @Override
    public int getSize(User user) {
        return historyStorageJDBC.getSizeHistoryOperation(user);
    }

    @Override
    public Operation getCurrentElement() {
        return listOperation.get(index);
    }

    @Override
    public List<Operation> getPreviousElements(int count) {
        List<Operation> listPreviousElements = null;

        if (listOperation != null && listIterator != null && listIterator.hasPrevious()) {
            listPreviousElements = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                if (listIterator.hasPrevious()) {
                    listPreviousElements.add(listIterator.previous());
                    index--;
//                    System.out.println(index);
                }
            }
        }

        return listPreviousElements;
    }

    @Override
    public List<Operation> getNextElements(int count) {
        List<Operation> listNextElements = null;

        if (listOperation != null && listIterator != null && listIterator.hasNext()) {
            listNextElements = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                if (listIterator.hasNext()) {
                    listNextElements.add(listIterator.next());
                    index++;
//                    System.out.println(index);
                }
            }
        }

        return listNextElements;
    }

    @Override
    public void resetIndex() {
        if (listIterator != null && listOperation != null) {
            listIterator = listOperation.listIterator();
            index = 0;
        }
    }
}
