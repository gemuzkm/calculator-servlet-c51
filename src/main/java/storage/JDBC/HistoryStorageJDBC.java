package storage.JDBC;

import entity.Operation;
import storage.Constants;
import storage.HistoryStorage;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
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

    }

    @Override
    public void del(String userLogin, int idItemHistory) {

    }

    @Override
    public Map<String, List<Operation>> getMapHistoryOperation() {
        return null;
    }

    private int getUserIdByLogin (String userLogin) {
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
