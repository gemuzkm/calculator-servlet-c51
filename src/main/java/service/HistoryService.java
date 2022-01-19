package service;

import store.HistoryOperation;

import java.util.ArrayList;

public class HistoryService {
    private HistoryOperation historyOperation = new HistoryOperation();

    public String printHistory() {
        ArrayList<String> listHistoryOperation = historyOperation.getListHistoryOperation();

        if (listHistoryOperation.size() == 0) {
            return "Empty";
        }  else {
            String history = "";
            for (String line : listHistoryOperation) {
                history += line + "\n";
            }
            return history;
        }
    }
}
