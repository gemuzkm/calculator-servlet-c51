package service;

import entity.Operation;
import entity.User;
import entity.ValueOne;
import entity.ValueTwo;
import storage.HistoryStorageInMemory;

import java.util.HashMap;
import java.util.Map;

public class CalculatorService {

    private HistoryStorageInMemory historyStorageInMemory = HistoryStorageInMemory.getInstance();

    public String getResult(ValueOne valueFirst, ValueTwo valueSecond, Operation operation, User user) {

        String result = getResultOperation(valueFirst, valueSecond, operation);
        String resultOperation = valueFirst.getValue() + " " + operation.getValue() + " " + valueSecond.getValue() + " = " + result;

        historyStorageInMemory.add(user.getLogin(), resultOperation);
        return result;
    }

    private String getResultOperation(ValueOne valueFirst, ValueTwo valueSecond, Operation operation) {
        String resultOperation = "";

        if (operation.getValue().equals("sum")) {
            resultOperation = String.valueOf(valueFirst.getValue() + valueSecond.getValue());
            return resultOperation;
        } else if (operation.getValue().equals("dif")) {
            resultOperation = String.valueOf(valueFirst.getValue() - valueSecond.getValue());
            return resultOperation;
        } else if (operation.getValue().equals("div")) {
            if (valueSecond.getValue() == 0) {
                resultOperation = "NaN";
            } else {
                resultOperation = String.valueOf(valueFirst.getValue() / valueSecond.getValue());
            }
            return resultOperation;
        } else if (operation.getValue().equals("mult")) {
            resultOperation = String.valueOf(valueFirst.getValue() * valueSecond.getValue());
            return resultOperation;
        }
        return resultOperation;
    }

    public String printHistory(String userLogin) {

        Map<String, String> mapHistoryOperation = historyStorageInMemory.getMapHistoryOperation();

        if (mapHistoryOperation.containsKey(userLogin)) {
            return mapHistoryOperation.get(userLogin);
        } else {
            return "Empty";
        }
    }

    public void delHistory(String userLogin) {
        historyStorageInMemory.del(userLogin);
    }
}
