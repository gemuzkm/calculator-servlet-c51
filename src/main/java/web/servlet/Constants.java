package web.servlet;

public final class Constants {

    private Constants() {
    }

    //links to JSP pages
    public static final String PATH_CALCULATOR_LINK_JSP = "/pages/user/calc.jsp";
    public static final String PATH_HISTORY_LINK_JSP = "/pages/user/history.jsp";
    public static final String PATH_REGISTRATION_LINK_JSP = "/pages/user/reg.jsp";
    public static final String PATH_CREATE_USER_LINK_JSP = "/pages/admin/createuser.jsp";
    public static final String PATH_LIST_USER_LINK_JSP = "/pages/admin/listuser.jsp";
    public static final String PATH_EDIT_USER_LINK_JSP = "/pages/admin/edituser.jsp";
    public static final String PATH_RECOVERY_USER_LINK_JSP = "/pages/recovery/recovery.jsp";
    public static final String PATH_NEW_PASSWORD_LINK_JSP = "/pages/recovery/newpassword.jsp";
    public static final String PATH_HOME_LINK_JSP = "/pages/index.jsp";
    public static final String PATH_LOGIN_LINK_JSP = "/pages/user/login.jsp";
    public static final String PATH_PROFILE_USER_LINK_JSP = "/pages/user/profile.jsp";

    //servlet name
    public static final String NAME_PROFILE_SERVLET = "ProfileServlet";
    public static final String NAME_REGISTRATION_SERVLET = "RegistrationServlet";
    public static final String NAME_LOGIN_SERVET = "LoginServlet";

    //servlet links
    public static final String URL_HOME_SERVLET = "/";
    public static final String URL_PROFILE_SERVLET = "/profile";
    public static final String URL_LOGIN_SERVLET = "/login";
    public static final String URL_LOGOUT_SERVLET = "/logout";
    public static final String URL_USER_DEL_SERVLET = "/deluser";
    public static final String URL_USER_LIST_SERVLET = "/listuser";
    public static final String URL_USER_EDIT_SERVLET = "/edituser";
    public static final String URL_USER_CREATE_SERVLET = "/createuser";
    public static final String URL_CALCULATOR_SERVLET = "/calculator";
    public static final String URL_HISTORY_SERVLET = "/history";
    public static final String URL_REGISTRATION_SERVLET = "/registration";

    //Messages
    public static final String MSC_ERROR_USER_NOT_CREATED = "Error. User not created";
    public static final String MSG_ERROR_USER_EXISTS = "Error. The user already exists";
    public static final String MSG_ERROR_USER_NOT_FOUND = "User not found";
}
