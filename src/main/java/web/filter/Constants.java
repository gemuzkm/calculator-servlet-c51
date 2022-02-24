package web.filter;

public final class Constants {

    private Constants() {
    }

    //links to JSP pages
    public static final String PATH_HOME_LINK_JSP = "/pages/profile.jsp";
    public static final String PATH_CALCULATOR_LINK_JSP = "/pages/user/calc.jsp";
    public static final String PATH_LOGIN_LINK_JSP = "/pages/user/login.jsp";
    public static final String PATH_REGISTRATION_LINK_JSP = "/pages/user/reg.jsp";
    public static final String PATH_INFORMATION_LINK_JSP = "/pages/informational.jsp";
    public static final String PATH_CREATE_USER_LINK_JSP = "/pages/admin/createuser.jsp";
    public static final String PATH_RECOVERY_USER_LINK_JSP = "/pages/recovery/recovery.jsp";
    public static final String PATH_NEW_PASSWORD_LINK_JSP = "/pages/recovery/newpassword.jsp";
    public static final String PATH_PROFILE_USER_LINK_JSP = "/pages/user/profile/profile.jsp";

    //servlet name
    public static final String NAME_PROFILE_SERVLET = "ProfileServlet";
    public static final String NAME_CALCULATOR_SERVLET = "CalculatorServlet";
    public static final String NAME_DEL_HISTORY_SERVLET = "DelHistory";
    public static final String NAME_HISTORY_SERVLET = "HistoryServlet";
    public static final String NAME_REGISTRATION_SERVLET = "RegistrationServlet";
    public static final String NAME_LOGIN_SERVLET = "LoginServlet";
    public static final String NAME_LIST_USER_SERVLET = "ListUserServlet";
    public static final String NAME_EDIT_USER_SERVLET = "EditUserServlet";
    public static final String NAME_DEL_USER_SERVLET = "DelUserServlet";
    public static final String NAME_CREATE_USER_SERVLET = "CreateUserServlet";
    public static final String NAME_UPDATE_PASSWORD_SERVLET = "UpdatePasswordServlet";
    public static final String NAME_RECOVERY_SERVLET = "RecoveryServlet";

    //servlet links
    public static final String URL_HOME = "/";
    public static final String URL_USER_LIST = "/listuser";
    public static final String URL_USER_EDIT = "/edituser";


    //Messages
    public static final String MSG_ERROR_NO_ACCESS = "No access";
    public static final String MSG_ERROR_NO_AUTHORIZED = "Welcome, Anonymous. You are not authorized";
    public static final String MSG_ERROR_NAME_EMPTY = "Name is empty";
    public static final String MSG_ERROR_LOGIN_EMPTY = "Login is empty";
    public static final String MSG_ERROR_PASSWORD_EMPTY = "Password is empty";
    public static final String MSG_ERROR_ROLE_INVALID = "The role is wrong";
    public static final String MSG_ERROR_USER_NOT_FOUND = "User not found";
    public static final String MSG_ERROR_LOGIN_OR_PASSWORD_INVALID = "Login or password error";
    public static final String MSG_ERROR_OPERATION_UNSUPPORTED = "Operator unsupported";
    public static final String MSG_ERROR_VALUE_TWO_NOT_NUMBER = "Value2 not a number";
    public static final String MSG_ERROR_VALUE_ONE_NOT_NUMBER = "Value1 not a number";
    public static final String MSG_ERROR_OPERATION_EMPTY = "Operator is empty";
    public static final String MSG_ERROR_VALUE_TWO_EMPTY = "Value2 is empty";
    public static final String MSG_ERROR_VALUE_ONE_EMPTY = "Value1 is empty";
    public static final String MSG_ERROR_NO_DEL_YOURSELF = "Error. You can't delete yourself";
    public static final String MSG_ERROR_SECRET_WORD_WRONG = "The secret word is wrong";
    public static final String MSG_ERROR_SECRET_WORLD_EMPTY = "Secret word is empty";
}
