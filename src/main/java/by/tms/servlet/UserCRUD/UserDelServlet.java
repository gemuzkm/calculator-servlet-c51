package by.tms.servlet.UserCRUD;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/userdel", name = "DelUserServlet")
public class UserDelServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        User userDel = userService.getByUserLogin(req.getParameter("login"));

        userService.delUser(userDel);

        resp.sendRedirect("/userlist");
    }
}
