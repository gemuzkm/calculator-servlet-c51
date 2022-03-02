package service;

import dao.JDBC.HistoryStorageJDBC;
import entity.Operation;
import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ValueListHandler {

    private HistoryStorageJDBC historyStorageJDBC = HistoryStorageJDBC.getInstance();

    private List<Operation> listOperation = null;
    private ListIterator<Operation> listIterator = null;
    private int index;

    public ValueListHandler() {
    }

    public void setListHandler(User user) {
        if (listIterator == null) {
            listOperation = historyStorageJDBC.getListHistoryOperation(user.getLogin());
        }

        if (listIterator == null) {
            listIterator = listOperation.listIterator();
        }

    }

    public int getSize(User user) {
        return historyStorageJDBC.getSizeHistoryOperation(user);
    }

    public Operation getCurrentElement() {
        return listOperation.get(index);
    }

    public List<Operation> getPreviousElements(User user, int count) {
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

    public List<Operation> getNextElements(User user, int count) {
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

    public void resetIndex() {
        if (listIterator != null && listOperation != null) {
            listIterator = listOperation.listIterator();
            index = 0;
        }
    }
}
