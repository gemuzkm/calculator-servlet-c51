package by.tms.servlet;

import entity.User;
import service.UserService;
import storage.UserStorageInMemory;
import validator.UserValidation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login", name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserValidation userValidation = new UserValidation();
        UserStorageInMemory userStorageInMemory = new UserStorageInMemory();
        UserService userService = new UserService();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (userValidation.validUserPassword(login,password) == null) {
            resp.getWriter().println("Incorrect parameters");
        } else {
            User user = userStorageInMemory.getByUserLogin(login);
            HttpSession session = req.getSession();

            session.setAttribute("login", login);
            user.setSessionID(session.getId());
            userService.checkUserSessionID(login, session.getId());
            resp.getWriter().println("Authorized successfully");
        }
    }
}
