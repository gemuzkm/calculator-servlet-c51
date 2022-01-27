package storage.Imp;

import java.util.HashMap;

public interface HistoryStorage {

    void add(String userLogin, String inputСalculations);
    void del(String userLogin);
    HashMap<String, String> getMapHistoryOperation();
}
