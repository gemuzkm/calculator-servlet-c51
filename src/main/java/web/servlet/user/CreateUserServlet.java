package web.servlet.user;

import web.servlet.Constants;
import entity.User;
import service.UserService;
import web.validator.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = Constants.URL_USER_CREATE_SERVLET, name = "CreateUserServlet")
public class CreateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(Constants.PATH_CREATE_USER_LINK_JSP).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        UserValidator userValidator = new UserValidator();
        HttpSession session = req.getSession();

        String userName = req.getParameter("name");
        String userLogin = req.getParameter("login");
        String userPassword = req.getParameter("password");

        User user = new User(userName, userLogin, userPassword, session.getId());

        if (userService.getByUserLogin(user.getLogin()) == null) {
            userService.addUser(user);
            if (userValidator.existsUser(user)) {
                resp.sendRedirect(Constants.URL_HOME_SERVLET);
            } else {
                req.setAttribute("msgErrorUser", Constants.MSC_ERROR_USER_NOT_CREATED);
                req.getServletContext().getRequestDispatcher(Constants.PATH_CREATE_USER_LINK_JSP).forward(req, resp);
            }
        } else {
            req.setAttribute("msgErrorUser", Constants.MSG_ERROR_USER_EXISTS);
            req.getServletContext().getRequestDispatcher(Constants.PATH_CREATE_USER_LINK_JSP).forward(req, resp);
        }
    }
}
