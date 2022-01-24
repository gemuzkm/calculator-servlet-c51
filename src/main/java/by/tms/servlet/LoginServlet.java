package by.tms.servlet;

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

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (userValidation.validUserPassword(login,password) == null) {
            resp.getWriter().println("Incorrect parameters");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            System.out.println(session.getId());
            resp.getWriter().println("Authorized successfully");
        }
    }
}
