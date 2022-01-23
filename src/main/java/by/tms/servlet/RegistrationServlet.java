package by.tms.servlet;

import entity.User;
import storage.UserStorageInMemory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/registration", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String userLogin = req.getParameter("login");
        String userPassword = req.getParameter("password");

        UserStorageInMemory userStorageInMemory = new UserStorageInMemory();
        userStorageInMemory.addUser(new User(userName, userLogin, userPassword));


    }
}
