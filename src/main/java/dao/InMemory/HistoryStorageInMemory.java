package dao.InMemory;

import entity.Operation;
import dao.HistoryStorage;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private Map<String, List<Operation>> mapHistoryOperation = new HashMap<>();

    @Override
    public void add(String userLogin, Operation inputСalculations) {

        inputСalculations.setValue("Operator: " + inputСalculations.getValue() + ", Date: " + LocalDateTime.now());

        if (mapHistoryOperation.containsKey(userLogin)) {
            List<Operation> operationList = mapHistoryOperation.get(userLogin);
            operationList.add(inputСalculations);
            mapHistoryOperation.put(userLogin, operationList);
        } else {
            List<Operation> operationList = new ArrayList<>();
            operationList.add(inputСalculations);
            mapHistoryOperation.put(userLogin, operationList);
        }
    }

    @Override
    public void del(String userLogin) {
        mapHistoryOperation.remove(userLogin);
    }

    @Override
    public void del(String userLogin, int idItemHistory) {
        List<Operation> operationList = mapHistoryOperation.get(userLogin);
        operationList.remove(idItemHistory);
        mapHistoryOperation.put(userLogin, operationList);
    }

    @Override
    public Map<String, List<Operation>> getMapHistoryOperation() {
        return mapHistoryOperation;
    }
}