package dao;

import entity.Operation;

import java.util.List;
import java.util.Map;

public interface HistoryStorage <T, K extends Operation, V> {

    void add(T userLogin, K inputСalculations);
    void del(T userLogin);
    void del(T userLogin, V idItemHistory);
    Map<T, List<K>> getMapHistoryOperation();
}
