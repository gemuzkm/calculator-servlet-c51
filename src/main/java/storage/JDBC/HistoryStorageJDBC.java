package storage.JDBC;

import entity.Operation;
import storage.HistoryStorage;

import java.util.List;
import java.util.Map;

public class HistoryStorageJDBC implements HistoryStorage {
    private static HistoryStorageJDBC instance;

    private HistoryStorageJDBC() {
//        throw new RuntimeException();
    }

    public static HistoryStorageJDBC getInstance() {
        if (instance == null) {
            instance = new HistoryStorageJDBC();
        }
        return instance;
    }

    @Override
    public void add(String userLogin, Operation inputСalculations) {

    }

    @Override
    public void del(String userLogin) {

    }

    @Override
    public void del(String userLogin, int idItemHistory) {

    }

    @Override
    public Map<String, List<Operation>> getMapHistoryOperation() {
        return null;
    }
}
