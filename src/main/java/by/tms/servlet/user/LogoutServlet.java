package by.tms.servlet.user;

import by.tms.servlet.Constants;
import entity.User;
import service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = Constants.LOGOUT_LINK)
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CalculatorService calculatorService = new CalculatorService();
        HttpSession session = req.getSession();

        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            calculatorService.delHistory(user.getLogin());

            session.invalidate();
            resp.sendRedirect(Constants.HOME_LINK);
        } else {
            resp.sendRedirect(Constants.HOME_LINK);
        }
    }
}
