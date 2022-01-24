package service;

import storage.HistoryOperation;

import java.util.ArrayList;
import java.util.HashMap;

public class HistoryService {
    private HistoryOperation historyOperation = HistoryOperation.getInstance();
    private String userLogin = "";

    public String printHistory(String userLogin) {
//        ArrayList<String> listHistoryOperation = historyOperation.getListHistoryOperation();

//        if (listHistoryOperation.size() == 0) {
//            return "Empty";
//        }  else {
//            StringBuilder history = new StringBuilder();
//            for (String line : listHistoryOperation) {
//                history.append(String.format("%s\n", line));
//            }
//            return history.toString();
//        }
        HashMap<String, String> mapHistoryOperation = historyOperation.getMapHistoryOperation();

        if (mapHistoryOperation.containsKey(userLogin)) {
            return mapHistoryOperation.get(userLogin);
        } else {
            return "Empty";
        }
    }

    public void delHistory(String userLogin) {
        historyOperation.del(userLogin);
    }
}
