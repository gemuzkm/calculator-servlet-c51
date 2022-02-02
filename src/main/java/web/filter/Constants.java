package web.filter;

public final class Constants {

    private Constants() {
    }

    //links to JSP pages
    public static final String HOME_LINK_JSP = "/pages/index.jsp";
    public static final String CALCULATIOR_LINK_JSP = "/pages/user/calc.jsp";
    public static final String LOGIN_LINK_JSP = "/pages/user/login.jsp";
    public static final String REGISTRATION_LINK_JSP = "/pages/user/reg.jsp";
    public static final String INFORMATION_LINK_JSP = "/pages/informational.jsp";
    public static final String CREATE_USER_LINK_JSP = "/pages/admin/createuser.jsp";
    public static final String RECOVERY_USER_LINK_JSP = "/pages/recovery/recovery.jsp";
    public static final String NEW_PASSWORD_LINK_JSP = "/pages/recovery/newpassword.jsp";

    //servlet links
    public static final String USER_LIST_LINK = "/userlist";
    public static final String USER_EDIT_LINK = "/useredit";

    //Messages
    public static final String MSG_ERROR_NO_ACCESS = "No access";
    public static final String MSG_ERROR_NO_AUTHORIZED = "Welcome, Anonymous. You are not authorized";
    public static final String MSG_ERROR_NAME_EMPTY = "Name is empty";
    public static final String MSG_ERROR_LOGIN_EMPTY = "Login is empty";
    public static final String MSG_ERROR_PASSWORD_EMPTY = "Password is empty";
    public static final String MSG_ERROR_ROLE_INVALID = "The role is wrong";
    public static final String MSG_ERROR_USER_NOT_FOUND = "User not found";
    public static final String MSG_ERROR_LOGIN_OR_PASSWORD_INVALID = "Login or password error";
    public static final String MSG_ERROR_OPERATION_UNSUPPORTED = "Operation unsupported";
    public static final String MSG_ERROR_VALUE_TWO_NOT_NUMBER = "Value2 not a number";
    public static final String MSG_ERROR_VALUE_ONE_NOT_NUMBER = "Value1 not a number";
    public static final String MSG_ERROR_OPERATION_EMPTY = "Operation is empty";
    public static final String MSG_ERROR_VALUE_TWO_EMPTY = "Value2 is empty";
    public static final String MSG_ERROR_VALUE_ONE_EMPTY = "Value1 is empty";
    public static final String MSG_ERROR_NO_DEL_YOURSELF = "Error. You can't delete yourself";
    public static final String MSG_ERROR_SECRET_WORD_WRONG = "The secret word is wrong";
    public static final String MSG_ERROR_SERCRET_WOWRD_EMPTY = "Secret word is empty";
}
