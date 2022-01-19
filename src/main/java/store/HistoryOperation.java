package store;

import java.util.ArrayList;

public class HistoryOperation {
    private ArrayList<String> listHistoryOperation = new ArrayList<>();

    public void add(String inputСalculations) {
        listHistoryOperation.add(inputСalculations);
    }

    public ArrayList<String> getListHistoryOperation() {
        return listHistoryOperation;
    }
}

