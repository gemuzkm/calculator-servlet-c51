package service;

import dao.JDBC.HistoryStorageJDBC;
import entity.Operation;
import entity.User;

import java.util.List;
import java.util.ListIterator;

public class ValueListHandler implements ValueListIterator<Operation> {
    private CalculatorService calculatorService = new CalculatorService();

    private Operation operation;
    private List<Operation>  operationList;
    private User user;
    private int index;

    public ValueListHandler(User user) {
        this.user = user;
    }

    @Override
    public int getSize() {
       return calculatorService.getSizeHistoryItem(user.getLogin());

       ///return size element;
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
        //отдал элементы и получил еще на страницу новые операции
    }
}
