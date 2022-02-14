package dao;

import entity.Operation;

import java.util.List;
import java.util.Map;

public interface HistoryStorage {

    void add(String userLogin, Operation inputСalculations);
    void del(String userLogin);
    void del(String userLogin, int idItemHistory);
    Map<String, List<Operation>> getMapHistoryOperation();
}
