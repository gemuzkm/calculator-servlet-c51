package storage;

import java.time.LocalDateTime;
import java.util.HashMap;

public class HistoryOperation {
    private static HistoryOperation instance;

    private HistoryOperation() {
    }

    public static HistoryOperation getInstance() {
        if (instance == null) {
            instance = new HistoryOperation();
        }
        return instance;
    }

//    private ArrayList<String> listHistoryOperation = new ArrayList<>();
    private HashMap<String, String> mapHistoryOperation = new HashMap<>();

//    public void add(String inputСalculations) {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        inputСalculations = "Operation: " + inputСalculations + ", Date: " + localDateTime;
//        listHistoryOperation.add(inputСalculations);
//    }

    public void add(String userLogin, String inputСalculations) {
        LocalDateTime localDateTime = LocalDateTime.now();
        inputСalculations = "Operation: " + inputСalculations + ", Date: " + localDateTime;

        if (mapHistoryOperation.containsKey(userLogin)) {
            StringBuilder addNewOperation = new StringBuilder(mapHistoryOperation.get(userLogin));
            addNewOperation.append(String.format("%s\n", inputСalculations));
            mapHistoryOperation.put(userLogin, addNewOperation.toString());
        } else {
            StringBuilder addNewOperation = new StringBuilder(String.format("%s\n", inputСalculations));
            mapHistoryOperation.put(userLogin, addNewOperation.toString());
        }
    }

    public void del(String userLogin) {
        mapHistoryOperation.remove(userLogin);
    }

//    public ArrayList<String> getListHistoryOperation() {
//        return listHistoryOperation;
//    }

    public HashMap<String, String> getMapHistoryOperation() {
        return mapHistoryOperation;
    }
}