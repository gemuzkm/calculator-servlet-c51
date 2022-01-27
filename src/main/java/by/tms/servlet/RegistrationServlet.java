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

@WebServlet(urlPatterns = "/registration", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        UserValidation userValidation = new UserValidation();
        HttpSession session = req.getSession();

        String userName = req.getParameter("name");
        String userLogin = req.getParameter("login");
        String userPassword = req.getParameter("password");

        session.setAttribute("login", userLogin);
        User user = new User(userName, userLogin, userPassword, session.getId());

        if (userService.getByUserLogin(user.getLogin()) == null) {
            userService.addUser(user);
            if (userValidation.existsUser(user)) {
                req.setAttribute("resultOperation", "Registration was successful");
                req.getServletContext().getRequestDispatcher("/pages/resultredir.jsp").forward(req, resp);
            } else {
                req.setAttribute("msgErrorUser", "Error. User not created");
                req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msgErrorUser", "Error. The user already exists");
            req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
        }
    }
}