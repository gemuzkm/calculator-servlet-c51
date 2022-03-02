package dao.JDBC;

public final class Constants {
    private Constants() {
    }

    //UserStorageJDBC - queries
    public static final String JDBC_ADD_USER = "INSERT INTO users (user_name, user_login, user_password, user_session_id) VALUES (?,?,?,?)";
    public static final String JDBC_UPDATE_USER = "UPDATE users SET user_name = ?, user_login = ?, user_password = ?, user_session_id = ?, role_id = ? WHERE user_login = ?";
    public static final String JDBC_GET_USER_BY_LOGIN = "SELECT user_name, user_login, user_password, user_session_id, role_id from users where user_login = ?";
    public static final String JDBC_DEL_USER_BY_USER = "DELETE FROM users where user_login = ?";
    public static final String JDBC_DEL_USER_BY_LOGIN = "DELETE FROM users where user_login = ?";
    public static final String JDBC_GET_LIST_USER = "SELECT user_name, user_login, user_password, user_session_id, role_id FROM users";

    //HistoryStorageJDBC - queries
    public static final String JDBC_ADD_HISTORY_OPERATION = "INSERT INTO history (operation_value, user_id) VALUES (?, ?)";
    public static final String JDBC_DEL_HISTORY_BY_LOGIN = "DELETE FROM history where user_id = ?";
    public static final String JDBC_DEL_HISTORY_BU_LOGIN_AND_ID_ITEM = "DELETE FROM history where user_id = ? AND operation_id = ?";
    public static final String JDBC_GET_OPERATION_ID_BY_USER = "SELECT * FROM history where user_id = ? LIMIT ? OFFSET ?";
    public static final String JDBC_GET_MAT_HISTORY_OPERATION = "SELECT user_login, operation_value FROM history INNER JOIN users ON history.user_id = users.user_id";
    public static final String JDBC_GET_SIZE_HISTORY_OPERATION = "SELECT user_login, operation_value FROM history INNER JOIN users ON history.user_id = users.user_id WHERE user_login = ?";
    public static final String JDBC_GET_USER_ID_BY_LOGIN = "SELECT user_id FROM users WHERE user_login = ?";
}
