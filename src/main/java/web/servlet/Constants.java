package web.servlet;

public final class Constants {

    private Constants() {
    }

    //links to JSP pages
    public static final String CALCULATOR_LINK_JSP = "/pages/user/calc.jsp";
    public static final String HISTORY_LINK_JSP = "/pages/user/history.jsp";
    public static final String REGISTRATION_LINK_JSP = "/pages/user/reg.jsp";
    public static final String CREATE_USER_LINK_JSP = "/pages/admin/createuser.jsp";
    public static final String EDIT_USER_LINK_JSP = "/pages/admin/edituser.jsp";
    public static final String LIST_USER_LINK_JSP = "/pages/admin/listuser.jsp";
    public static final String RECOVERY_USER_LINK_JSP = "/pages/recovery/recovery.jsp";
    public static final String NEW_PASSWORD_LINK_JSP = "/pages/recovery/newpassword.jsp";
    public static final String HOME_LINK_JSP = "/pages/index.jsp";
    public static final String LOGIN_LINK_JSP = "/pages/user/login.jsp";
    public static final String PROFILE_USER_LINK_JSP = "/pages/user/profile/index.jsp";

    //servlet links
    public static final String HOME_LINK = "/home";
    public static final String LOGIN_LINK = "/login";
    public static final String LOGOUT_LINK = "/logout";
    public static final String USER_DEL_LINK = "/deluser";
    public static final String USER_LIST_LINK = "/listuser";
    public static final String USER_EDIT_LINK = "/edituser";
    public static final String USER_CREATE_LINK = "/createuser";
    public static final String PASSWORD_RECOVERY_LINK = "/recovery";
    public static final String CALCULATOR_LINK = "/calculator";
    public static final String HISTORY_LINK = "/history";
    public static final String HISTORY_DEL_LINK = "/delhistory";

    //Messages
    public static final String MSC_ERROR_USER_NOT_CREATED = "Error. User not created";
    public static final String MSG_ERROR_USER_EXISTS = "Error. The user already exists";
    public static final String MSG_ERROR_USER_NOT_FOUND = "User not found";
}
