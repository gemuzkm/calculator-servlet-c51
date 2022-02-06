package service;

import entity.Operator;
import entity.User;
import entity.ValueOne;
import entity.ValueTwo;
import storage.HistoryStorageInMemory;

import java.util.Map;

public class CalculatorService {

    private HistoryStorageInMemory historyStorageInMemory = HistoryStorageInMemory.getInstance();

    public String getResult(ValueOne valueFirst, ValueTwo valueSecond, Operator operator, User user) {

        String result = getResultOperation(valueFirst, valueSecond, operator);
        String resultOperation = valueFirst.getValue() + " " + operator.getValue() + " " + valueSecond.getValue() + " = " + result;

        historyStorageInMemory.add(user.getLogin(), resultOperation);
        return result;
    }

    private String getResultOperation(ValueOne valueFirst, ValueTwo valueSecond, Operator operator) {
        String resultOperation = "";

        if (operator.getValue().equals("sum")) {
            resultOperation = String.valueOf(valueFirst.getValue() + valueSecond.getValue());
            return resultOperation;
        } else if (operator.getValue().equals("dif")) {
            resultOperation = String.valueOf(valueFirst.getValue() - valueSecond.getValue());
            return resultOperation;
        } else if (operator.getValue().equals("div")) {
            if (valueSecond.getValue() == 0) {
                resultOperation = "NaN";
            } else {
                resultOperation = String.valueOf(valueFirst.getValue() / valueSecond.getValue());
            }
            return resultOperation;
        } else if (operator.getValue().equals("mult")) {
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
