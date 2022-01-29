package service;

import entity.Operation;
import entity.ValueOne;
import entity.ValueTwo;
import storage.HistoryStorageInMemory;

import java.util.HashMap;

public class CalculatorService {
    private String valueFirst = "";
    private String valueSecond = "";
    private String operation = "";
    private String userLogin = "";

    private HistoryStorageInMemory historyStorageInMemory = HistoryStorageInMemory.getInstance();

//    public CalculatorService() {
//    }

//    public CalculatorService(String valueFirst, String valueSecond, String operation, String userLogin) {
//        this.valueFirst = valueFirst;
//        this.valueSecond = valueSecond;
//        this.operation = operation;
//        this.userLogin = userLogin;
//    }

//    public String getResult() {
//
//        double valueFirstDouble = Double.parseDouble(valueFirst);
//        double valueSecondDouble = Double.parseDouble(valueSecond);
//        String result = getResultOperation(valueFirstDouble, valueSecondDouble, operation);
//        String resultOperation = valueFirst + " " + operation + " " + valueSecond + " = " + result;
//
//        historyStorageInMemory.add(userLogin, resultOperation);
//        return result;
//    }

    public String getResult(ValueOne valueFirst, ValueTwo valueSecond, Operation operation, String userLogin) {

        String result = getResultOperation(valueFirst, valueSecond, operation);
        String resultOperation = valueFirst.getValue() + " " + operation.getValue() + " " + valueSecond.getValue() + " = " + result;

        historyStorageInMemory.add(userLogin, resultOperation);
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

//    private String getResultOperation(double valueFirst, double valueSecond, String operation) {
//        String resultOperation = "";
//
//        if (operation.equals("sum")) {
//            resultOperation = String.valueOf(valueFirst + valueSecond);
//            return resultOperation;
//        } else if (operation.equals("dif")) {
//            resultOperation = String.valueOf(valueFirst - valueSecond);
//            return resultOperation;
//        } else if (operation.equals("div")) {
//            if (valueSecond == 0) {
//                resultOperation = "NaN";
//            } else {
//                resultOperation = String.valueOf(valueFirst / valueSecond);
//            }
//            return resultOperation;
//        } else if (operation.equals("mult")) {
//            resultOperation = String.valueOf(valueFirst * valueSecond);
//            return resultOperation;
//        }
//    return resultOperation;
//    }

    public String printHistory(String userLogin) {

        HashMap<String, String> mapHistoryOperation = historyStorageInMemory.getMapHistoryOperation();

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
