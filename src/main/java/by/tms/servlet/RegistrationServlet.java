package by.tms.servlet;

import entity.User;
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
        UserStorageInMemory userStorageInMemory = new UserStorageInMemory();
        UserValidation userValidation = new UserValidation();
        HttpSession session = req.getSession();

        String userName = req.getParameter("name");
        String userLogin = req.getParameter("login");
        String userPassword = req.getParameter("password");

        User user = new User(userName, userLogin, userPassword);

        if (userStorageInMemory.getByUserLogin(user.getLogin()) == null) {
            userStorageInMemory.addUser(user);
            if (userValidation.existsUser(user)) {
                resp.getWriter().println("Registration was successful.");
                System.out.println(session.getId());
            } else {
                resp.getWriter().println("Error. User not created.");
            }
        } else {
            resp.getWriter().println("Error. The user already exists.");
        }
    }
}
