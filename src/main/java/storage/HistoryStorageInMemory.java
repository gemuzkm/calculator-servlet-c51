package storage;

import java.time.LocalDateTime;

import java.util.HashMap;

public class HistoryStorageInMemory implements HistoryStorage {
    private static HistoryStorageInMemory instance;

    private HistoryStorageInMemory() {
//        throw new RuntimeException();
    }

    public static HistoryStorageInMemory getInstance() {
        if (instance == null) {
            instance = new HistoryStorageInMemory();
        }
        return instance;
    }
    /// Operation
    // list Operation

//    private Map<String, ArrayList <Operation>> mapHistoryOperation = new HashMap<>();

    private HashMap<String, String> mapHistoryOperation = new HashMap<>();

    @Override
    public void add(String userLogin, String inputСalculations) {
        LocalDateTime localDateTime = LocalDateTime.now();
        inputСalculations = "Operation: " + inputСalculations + ", Date: " + localDateTime;

        if (mapHistoryOperation.containsKey(userLogin)) {
            StringBuilder addNewOperation = new StringBuilder(mapHistoryOperation.get(userLogin));
            addNewOperation.append(String.format("%s %s", inputСalculations, "<br>"));
            mapHistoryOperation.put(userLogin, addNewOperation.toString());
        } else {
            StringBuilder addNewOperation = new StringBuilder(String.format("%s %s", inputСalculations, "<br>"));
            mapHistoryOperation.put(userLogin, addNewOperation.toString());
        }
    }

    @Override
    public void del(String userLogin) {
        mapHistoryOperation.remove(userLogin);
    }

    @Override
    public HashMap<String, String> getMapHistoryOperation() {
        return mapHistoryOperation;
    }
}