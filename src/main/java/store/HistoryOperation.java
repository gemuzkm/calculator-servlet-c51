package store;

import java.util.ArrayList;

public class HistoryOperation {
    private ArrayList<String> listHistoryOperation = new ArrayList<>();

    public void add(String value1, String value2, String operation, String result) {
        String addLine = value1 + " " + operation + " " + value2 + " = " + result;
        listHistoryOperation.add(addLine);
    }

    public ArrayList<String> getListHistoryOperation() {
        return listHistoryOperation;
    }
}

