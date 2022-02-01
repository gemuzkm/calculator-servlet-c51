package web.servlet.user;

import web.servlet.Constants;
import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = Constants.LOGIN_LINK, name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(Constants.LOGIN_LINK_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        HttpSession session = req.getSession();

        String login = req.getParameter("login");
        User user = userService.getByUserLogin(login);

 //       session.setAttribute("login", login);
        session.setAttribute("user", user);

        if (userService.changedUserSessionID(user.getLogin(), session.getId())) {
            userService.deleteHistoryAfterIdChange(user.getLogin(), session.getId());
            user.setSessionID(session.getId());
        } else {
            user.setSessionID(session.getId());
        }

        resp.sendRedirect(Constants.HOME_LINK);
    }
}
