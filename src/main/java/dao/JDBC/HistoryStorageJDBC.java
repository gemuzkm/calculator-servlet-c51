package dao.JDBC;

import entity.Operation;
import dao.HistoryStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryStorageJDBC implements HistoryStorage<String, Operation, Integer> {
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

    private final String JDBC_URL = "jdbc:mysql://193.122.63.237:3306/servlet-c51?useUnicode=true&serverTimezone=UTC";
    private final String JDBC_USER_NAME = "servlet-c51_usr";
    private final String JDBC_PASSWORD = "KEvUShZilD74CaBG";

    @Override
    public void add(String userLogin, Operation inputСalculations) {
        try {
            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(Constants.JDBC_ADD_HISTORY_OPERATION);
                preparedStatement.setString(1, inputСalculations.getValue());
                preparedStatement.setInt(2, getUserIdByLogin(userLogin));
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void del(String userLogin) {
        try {
            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(Constants.JDBC_DEL_HISTORY_BY_LOGIN);
                preparedStatement.setInt(1, getUserIdByLogin(userLogin));
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void del(String userLogin, Integer idItemHistory) {
        try {
            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(Constants.JDBC_DEL_HISTORY_BU_LOGIN_AND_ID_ITEM);
                preparedStatement.setInt(1, getUserIdByLogin(userLogin));
                preparedStatement.setInt(2, getOperationIdByUser(userLogin, idItemHistory));
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getOperationIdByUser(String userLogin, int idItemHistory) {
        try {
            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(Constants.JDBC_GET_OPERATION_ID_BY_USER);
                preparedStatement.setInt(1, getUserIdByLogin(userLogin));
                preparedStatement.setInt(2, 1);
                preparedStatement.setInt(3, idItemHistory);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Map<String, List<Operation>> getMapHistoryOperation() {
        try {
            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(Constants.JDBC_GET_MAT_HISTORY_OPERATION);
                ResultSet resultSet = preparedStatement.executeQuery();
                Map<String, List<Operation>> mapOperation = new HashMap<>();

                while (resultSet.next()) {
                    String userLogin = resultSet.getString(1);
                    String operationValue = resultSet.getString(2);
                    List<Operation> listOperation;

                    if (mapOperation.containsKey(userLogin)) {
                        listOperation = mapOperation.get(userLogin);
                    } else {
                        listOperation = new ArrayList<>();
                    }

                    listOperation.add(new Operation(operationValue));

                    mapOperation.put(userLogin, listOperation);
                }
                return mapOperation;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int getUserIdByLogin(String userLogin) {
        try {
            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(Constants.JDBC_GET_USER_ID_BY_LOGIN);
                preparedStatement.setString(1, userLogin);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}