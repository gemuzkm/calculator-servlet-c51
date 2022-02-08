package service;

import entity.*;
import storage.JDBC.HistoryStorageJDBC;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CalculatorService {

    private HistoryStorageJDBC historyStorageJDBC = HistoryStorageJDBC.getInstance();

    public String getResult(ValueOne valueFirst, ValueTwo valueSecond, Operator operator, User user) {

        String result = getResultOperation(valueFirst, valueSecond, operator);
        String resultOperation = valueFirst.getValue() + " " + operator.getValue() + " " + valueSecond.getValue() + " = " + result + LocalDateTime.now();

        historyStorageJDBC.add(user.getLogin(), new Operation(resultOperation));
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

    public List<Operation> getHistory(String userLogin) {

        Map<String, List<Operation>> mapHistoryOperation = historyStorageJDBC.getMapHistoryOperation();

        if (mapHistoryOperation.containsKey(userLogin)) {
            return mapHistoryOperation.get(userLogin);
        } else {
            List<Operation> operationList = new ArrayList<>();
            operationList.add(new Operation("Empty"));
            return operationList;
        }
    }

    public void delHistory(String userLogin) {
        historyStorageJDBC.del(userLogin);
    }

    public void delHistory(String userLogin, int idItemHistory) {
        historyStorageJDBC.del(userLogin, idItemHistory);
    }
}
