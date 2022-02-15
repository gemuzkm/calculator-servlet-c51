package dao.JDBC;

import entity.User;
import dao.UserStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserStorageJDBC implements UserStorage<User, String> {

    private static UserStorageJDBC instance;

    private UserStorageJDBC() {
    }

    public static UserStorageJDBC getInstance() {
        if (instance == null) {
            instance = new UserStorageJDBC();
        }
        return instance;
    }

    private final String JDBC_URL = "jdbc:mysql://193.122.63.237:3306/servlet-c51?useUnicode=true&serverTimezone=UTC";
    private final String JDBC_USER_NAME = "servlet-c51_usr";
    private final String JDBC_PASSWORD = "KEvUShZilD74CaBG";

    @Override
    public void addUser(User user) {
        if (getUserByLogin(user.getLogin()) == null) {
            try {
                try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD)) {
                    PreparedStatement preparedStatement = connection.prepareStatement(Constants.JDBC_ADD_USER);
                    preparedStatement.setString(1, user.getName());
                    preparedStatement.setString(2, user.getLogin());
                    preparedStatement.setString(3, user.getPassword());
                    preparedStatement.setString(4, user.getSessionID());
                    preparedStatement.execute();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD)) {
                    PreparedStatement preparedStatement = connection.prepareStatement(Constants.JDBC_UPDATE_USER);
                    preparedStatement.setString(1, user.getName());
                    preparedStatement.setString(2, user.getLogin());
                    preparedStatement.setString(3, user.getPassword());
                    preparedStatement.setString(4, user.getSessionID());
                    preparedStatement.setInt(5, user.getRole());
                    preparedStatement.setString(6, user.getLogin());
                    preparedStatement.execute();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public User getUserByLogin(String userLogin) {
        try {
            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(Constants.JDBC_GET_USER_BY_LOGIN);
                preparedStatement.setString(1, userLogin);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString(1);
                    String login = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    String sessionId = resultSet.getString(4);
                    int role = resultSet.getInt(5);
                    return new User(name, login, password, sessionId, role);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delUser(User user) {
        try {
            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(Constants.JDBC_DEL_USER_BY_USER);
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delUser(String userLogin) {
        try {
            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(Constants.JDBC_DEL_USER_BY_LOGIN);
                preparedStatement.setString(1, userLogin);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getListUser() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(Constants.JDBC_GET_LIST_USER);
                ResultSet resultSet = preparedStatement.executeQuery();

                List<User> userList = new ArrayList<>();
                while (resultSet.next()) {
                    String name = resultSet.getString(1);
                    String login = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    String sessionId = resultSet.getString(4);
                    int role = resultSet.getInt(5);
                    userList.add(new User(name, login, password, sessionId, role));
                }
                return userList;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}