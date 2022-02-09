package storage.JDBC;

public final class Constants {
    private Constants() {
    }

    //JDBC connect
    public static final String JDBC_URL = "jdbc:mysql://193.122.63.237:3306/servlet-c51?useUnicode=true&serverTimezone=UTC";
    public static final String JDBC_USER_NAME = "servlet-c51_usr";
    public static final String JDBC_PASSWORD = "KEvUShZilD74CaBG";

    //UserStorageJDBC - queries
    public static final String JDBC_ADD_USER = "INSERT INTO users (user_name, user_login, user_password, user_session_id) VALUES (?,?,?,?)";
    public static final String JDBC_UPDATE_USER = "UPDATE users SET user_name = ?, user_login = ?, user_password = ?, user_session_id = ? WHERE user_login = ?";
    public static final String JDBC_GET_USER_BY_LOGIN = "SELECT user_name, user_login, user_password, user_session_id, role_id from users where user_login = ?";
    public static final String JDBC_DEL_USER_BY_USER = "DELETE FROM users where user_login = ?";
    public static final String JDBC_DEL_USER_BY_LOGIN = "DELETE FROM users where user_login = ?";
    public static final String JDBC_GET_LIST_USER = "SELECT user_name, user_login, user_password, user_session_id, role_id FROM users";
}
