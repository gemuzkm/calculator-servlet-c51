package service;

import storage.HistoryOperation;

import java.util.ArrayList;

public class HistoryService {
    private HistoryOperation historyOperation = HistoryOperation.getInstance();

    public String printHistory() {
        ArrayList<String> listHistoryOperation = historyOperation.getListHistoryOperation();

        if (listHistoryOperation.size() == 0) {
            return "Empty";
        }  else {
            StringBuilder history = new StringBuilder();
            for (String line : listHistoryOperation) {
                history.append(String.format("%s\n", line));
            }
            return history.toString();
        }
    }
}
