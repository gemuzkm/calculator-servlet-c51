package service;

import dao.JDBC.HistoryStorageJDBC;
import entity.Operation;
import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ValueListHandler {
    private static ValueListHandler instance;

    private ValueListHandler() {

    }

    public static ValueListHandler getInstance() {
        if (instance == null) {
            instance = new ValueListHandler();
        }
        return instance;
    }

    HistoryStorageJDBC historyStorageJDBC = HistoryStorageJDBC.getInstance();

    private Operation operation;
    private List<Operation> listOperation = historyStorageJDBC.getListHistoryOperation("user");
    private ListIterator<Operation> listIterator =  listOperation.listIterator();;
    private User user;
    private int index;


    public void SetListHendler() {
//        listOperation = historyStorageJDBC.getListHistoryOperation(userLogin);
//        listIterator = listOperation.listIterator();
    }

    // общее количество элементов истории
    public int getSize(User user) {
        return historyStorageJDBC.getSizeHistoryOperation(user);
    }

    public Operation getCurrentElement() {
        return listOperation.get(index);
    }

    public List<Operation> getPreviousElements(int count) {
        List<Operation> listPreviousElements = null;

        if (listOperation != null && listIterator != null && listIterator.hasPrevious()) {
            listPreviousElements = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                if (listIterator.hasPrevious()) {
                    listPreviousElements.add(listIterator.previous());
                }
            }
        }

        return listPreviousElements;
    }

    public List<Operation> getNextElements(int count) {
        List<Operation> listNextElements = null;

        if (listOperation != null && listIterator != null && listIterator.hasNext()) {
            listNextElements = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                if (listIterator.hasNext()) {
                    listNextElements.add(listIterator.next());
                }
            }
        }
        return listNextElements;
        //отдал элементы и получил еще на страницу новые операции
    }

    public void resetIndex() {
        if (listIterator != null && listOperation != null) {
           listIterator = listOperation.listIterator();
        }
    }
}
