package store;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class HistoryOperation {


    public static ArrayList<String> listHistoryOperation = new ArrayList<>();

    public void add(String inputСalculations) {
        LocalDateTime localDateTime = LocalDateTime.now();
        inputСalculations = "Operation: " + inputСalculations + ", Date: " + localDateTime;
        listHistoryOperation.add(inputСalculations);
    }

    public ArrayList<String> getListHistoryOperation() {
        return listHistoryOperation;
    }
}