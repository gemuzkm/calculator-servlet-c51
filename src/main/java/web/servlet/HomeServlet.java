package web.servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = Constants.HOME_LINK)
public class HomeServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        UserService userService = new UserService();
        //role 0 = admin, 1 = user (default)
        User admin = new User("admin", "admin", "admin", "0", 0);
        User admin1 = new User("admin1", "admin1", "admin1", "1", 0);
        User admin2 = new User("admin2", "admin2", "admin2", "2", 0);
        User user = new User("user", "user", "user", "3", 1);

        userService.addUser(admin);
        userService.addUser(admin1);
        userService.addUser(admin2);
        userService.addUser(user);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(Constants.HOME_LINK_JSP).forward(req, resp);
    }
}