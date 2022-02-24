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
import java.util.List;

@WebServlet(urlPatterns = Constants.URL_USER_LIST_SERVLET, name = Constants.NAME_USER_LIST_SERVLET)
public class ListUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        List<User> listUser = userService.getListUser();
        req.setAttribute("listUser", listUser);
        req.getServletContext().getRequestDispatcher(Constants.PATH_LIST_USER_LINK_JSP).forward(req, resp);
    }
}
