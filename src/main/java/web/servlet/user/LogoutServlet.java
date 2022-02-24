package web.servlet.user;

import web.servlet.Constants;
import entity.User;
import service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = Constants.URL_LOGOUT_SERVLET)
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CalculatorService calculatorService = new CalculatorService();
        HttpSession session = req.getSession();

        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            calculatorService.delHistory(user.getLogin());

            session.invalidate();
            resp.sendRedirect(Constants.URL_HOME_SERVLET);
        } else {
            resp.sendRedirect(Constants.URL_HOME_SERVLET);
        }
    }
}
