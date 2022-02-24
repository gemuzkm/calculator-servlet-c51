package web.servlet.user;

import web.servlet.Constants;
import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = Constants.URL_USER_DEL_SERVLET, name = "DelUserServlet")
public class DelUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        User userDel = userService.getByUserLogin(req.getParameter("login"));


        if (userDel.getLogin().equals(req.getParameter("login"))) {
            userService.delUser(userDel);
        }

        resp.sendRedirect(Constants.URL_USER_LIST_SERVLET);
    }
}
