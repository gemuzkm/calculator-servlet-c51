package service;

import storage.HistoryStorage;

import java.util.HashMap;

public class HistoryService {
    private HistoryStorage historyStorage = HistoryStorage.getInstance();
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
        HashMap<String, String> mapHistoryOperation = historyStorage.getMapHistoryOperation();

        if (mapHistoryOperation.containsKey(userLogin)) {
            return mapHistoryOperation.get(userLogin);
        } else {
            return "Empty";
        }
    }

    public void delHistory(String userLogin) {
        historyStorage.del(userLogin);
    }
}
