package service;

import store.HistoryOperation;
import validator.OperationValidation;
import validator.ValueValidation;

public class CalculatorService {
    private String valueFirst = "";
    private String valueSecond = "";
    private String operation = "";

    private ValueValidation valueValidation = new ValueValidation();
    private OperationValidation operationValidation = new OperationValidation();
    private HistoryOperation historyOperation = HistoryOperation.getInstance();

    public CalculatorService(String valueFirst, String valueSecond, String operation) {
        this.valueFirst = valueFirst;
        this.valueSecond = valueSecond;
        this.operation = operation;
    }

    public String getResult() {
        String resultOperation = "";

        if (valueValidation.isNull(valueFirst) || valueValidation.isNull(valueSecond) || valueValidation.isNull(operation)) {
            return "Incorrect parameters";
        } else if (!operationValidation.supportedOperation(operation)) {
            return "Operation unsupported";
        } else if (!valueValidation.isNumber(valueFirst) || !valueValidation.isNumber(valueSecond)) {
            return "Transmitted parameters are not numbers";
        } else {
            double valueFirstDouble = Double.parseDouble(valueFirst);
            double valueSecondDouble = Double.parseDouble(valueSecond);
            resultOperation = valueFirst + " " + operation + " " + valueSecond + " = " + getResultOperation(valueFirstDouble, valueSecondDouble, operation);
        }
        historyOperation.add(resultOperation);
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
}
