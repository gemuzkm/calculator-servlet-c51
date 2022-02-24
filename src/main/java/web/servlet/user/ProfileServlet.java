package web.servlet.user;

import entity.User;
import service.UserService;
import web.servlet.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = Constants.URL_PROFILE_SERVLET, name = Constants.NAME_PROFILE_SERVLET)
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(Constants.PATH_PROFILE_USER_LINK_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        HttpSession session = req.getSession();

        String nameForEditingUser = (String) req.getParameter("name");
        String loginForEditingUser = (String) req.getParameter("login");
        String passwordForEditingUser = (String) req.getParameter("password");
        int roleForEditingUser = Integer.parseInt((String) req.getParameter("role"));
        String sessionIdForEditingUser = (String) req.getParameter("sessionID");

        User userForEditing = new User(nameForEditingUser, loginForEditingUser, passwordForEditingUser, sessionIdForEditingUser, roleForEditingUser);
        userService.addUser(userForEditing);

        session.setAttribute("user", userForEditing);

//        req.getServletContext().getRequestDispatcher(Constants.URL_PROFILE_SERVLET).forward(req, resp);
        resp.sendRedirect("/");
    }
}
