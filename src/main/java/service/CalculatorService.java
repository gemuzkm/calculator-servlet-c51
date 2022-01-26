package service;

import storage.HistoryStorageInMemory;

import java.util.HashMap;

public class CalculatorService {
    private String valueFirst = "";
    private String valueSecond = "";
    private String operation = "";
    private String userLogin = "";

    private HistoryStorageInMemory historyStorageInMemory = HistoryStorageInMemory.getInstance();

    public CalculatorService() {
    }

    public CalculatorService(String valueFirst, String valueSecond, String operation, String userLogin) {
        this.valueFirst = valueFirst;
        this.valueSecond = valueSecond;
        this.operation = operation;
        this.userLogin = userLogin;
    }

    public String getResult() {

        String resultOperation = "";

        double valueFirstDouble = Double.parseDouble(valueFirst);
        double valueSecondDouble = Double.parseDouble(valueSecond);
        resultOperation = valueFirst + " " + operation + " " + valueSecond + " = " + getResultOperation(valueFirstDouble, valueSecondDouble, operation);

        historyStorageInMemory.add(userLogin, resultOperation);
        return resultOperation;
    }

    private String getResultOperation(double valueFirst, double valueSecond, String operation) {
        String resultOperation = "";

        if (operation.equals("sum")) {
            resultOperation = String.valueOf(valueFirst + valueSecond);
            return resultOperation;
        } else if (operation.equals("dif")) {
            resultOperation = String.valueOf(valueFirst - valueSecond);
            return resultOperation;
        } else if (operation.equals("div")) {
            if (valueSecond == 0) {
                resultOperation = "NaN";
            } else {
                resultOperation = String.valueOf(valueFirst / valueSecond);
            }
            return resultOperation;
        } else if (operation.equals("mult")) {
            resultOperation = String.valueOf(valueFirst * valueSecond);
            return resultOperation;
        }
    return resultOperation;
    }

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
