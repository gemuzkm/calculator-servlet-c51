package storage;

import entity.Operation;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryStorageInMemory {
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
    /// Operator
    // list Operator

//    private Map<String, ArrayList <Operator>> mapHistoryOperation = new HashMap<>();

//    private HashMap<String, String> mapHistoryOperation = new HashMap<>();

    private Map<String, List<Operation>> mapHistoryOperation1 = new HashMap<>();


//    public void add(String userLogin, String inputСalculations) {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        inputСalculations = "Operator: " + inputСalculations + ", Date: " + localDateTime;
//
//        if (mapHistoryOperation1.containsKey(userLogin)) {
//            StringBuilder addNewOperation = new StringBuilder(mapHistoryOperation1.get(userLogin));
//            addNewOperation.append(String.format("%s %s", inputСalculations, "<br>"));
//            mapHistoryOperation1.put(userLogin, addNewOperation.toString());
//        } else {
//            StringBuilder addNewOperation = new StringBuilder(String.format("%s %s", inputСalculations, "<br>"));
//            mapHistoryOperation1.put(userLogin, addNewOperation.toString());
//        }
//    }

    public void add(String userLogin, Operation inputСalculations) {

        inputСalculations.setValue("Operator: " + inputСalculations.getValue() + ", Date: " + LocalDateTime.now());

        if (mapHistoryOperation1.containsKey(userLogin)) {
            List<Operation> operationList = mapHistoryOperation1.get(userLogin);
            operationList.add(inputСalculations);
            mapHistoryOperation1.put(userLogin, operationList);
        } else {
            List<Operation> operationList = new ArrayList<>();
            operationList.add(inputСalculations);
            mapHistoryOperation1.put(userLogin, operationList);
        }
    }


//    public void del(String userLogin) {
//        mapHistoryOperation.remove(userLogin);
//    }

    public void del(String userLogin) {
        mapHistoryOperation1.remove(userLogin);
    }

//    public HashMap<String, String> getMapHistoryOperation() {
//        return mapHistoryOperation;
//    }

    public Map<String, List<Operation>> getMapHistoryOperation() {
        return mapHistoryOperation1;
    }
}