package storage.JDBC;

import entity.Operation;
import storage.Constants;
import storage.HistoryStorage;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
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
        try {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(Constants.JDBC_URL, Constants.JDBC_USER_NAME, Constants.JDBC_PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO history (operation_value, user_id) VALUES (?, ?)");
                preparedStatement.setString(1, inputСalculations.getValue());
                preparedStatement.setInt(2, getUserIdByLogin(userLogin));

                preparedStatement.execute();
            }
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void del(String userLogin) {
        try {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(Constants.JDBC_URL, Constants.JDBC_USER_NAME, Constants.JDBC_PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "DELETE FROM history where user_id = ?");
                preparedStatement.setInt(1, getUserIdByLogin(userLogin));
                preparedStatement.execute();

            }
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void del(String userLogin, int idItemHistory) {
        try {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(Constants.JDBC_URL, Constants.JDBC_USER_NAME, Constants.JDBC_PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "DELETE FROM history where user_id = ? AND operation_id = ?");
                preparedStatement.setInt(1, getUserIdByLogin(userLogin));
                preparedStatement.setInt(2, getOperationIdByUser(userLogin, idItemHistory));
                preparedStatement.execute();

            }
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException | SQLException e) {
            e.printStackTrace();
        }
    }

    private int getOperationIdByUser(String userLogin, int idItemHistory) {
        try {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(Constants.JDBC_URL, Constants.JDBC_USER_NAME, Constants.JDBC_PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM history where user_id = ? LIMIT ? OFFSET ?");
                preparedStatement.setInt(1, getUserIdByLogin(userLogin));
                preparedStatement.setInt(2, 1);
                preparedStatement.setInt(3, idItemHistory);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException | SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Map<String, List<Operation>> getMapHistoryOperation() {
        try {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(Constants.JDBC_URL, Constants.JDBC_USER_NAME, Constants.JDBC_PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT user_login, operation_value FROM history INNER JOIN users ON history.user_id = users.user_id");
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
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int getUserIdByLogin(String userLogin) {
        try {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(Constants.JDBC_URL, Constants.JDBC_USER_NAME, Constants.JDBC_PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT user_id FROM users WHERE user_login = ?");
                preparedStatement.setString(1, userLogin);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException | SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
