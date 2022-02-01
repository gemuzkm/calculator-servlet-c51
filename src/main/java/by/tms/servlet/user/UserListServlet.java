package by.tms.servlet.user;

import by.tms.servlet.Constants;
import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = Constants.USER_LIST_LINK, name = "UserListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        ArrayList<User> listUser = userService.getListUser();
        req.setAttribute("listUser", listUser);
        req.getServletContext().getRequestDispatcher(Constants.LIST_USER_LINK_JSP).forward(req, resp);
    }
}
