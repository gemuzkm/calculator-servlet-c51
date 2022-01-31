package by.tms.servlet.RecoveryPassword;

import by.tms.servlet.Constants;
import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/updatepassword", name = "UpdatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        HttpSession session = req.getSession();

        String login = (String) session.getAttribute("login");
        User updateUser = userService.getByUserLogin(login);

        updateUser.setPassword(req.getParameter("newpassword"));
        updateUser.setSessionID((String) session.getId());

        userService.addUser(updateUser);
        session.invalidate();

        resp.sendRedirect(Constants.HOME_LINK);
    }
}
