package service;

import entity.Operation;
import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ValueListHandler {
    private CalculatorService calculatorService = new CalculatorService();

    private Operation operation;
    private List<Operation> listOperation;
    private ListIterator<Operation> listIterator;
    private User user;
    private int index;

    public ValueListHandler(User user, int recordPerPage) {
        listOperation = calculatorService.getHistory(user.getLogin());
    }

    // общее количество элементов истории
    public int getSize(User user) {
        return calculatorService.getSizeHistoryItem(user);
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
            listOperation.listIterator(0);
        }
    }
}
