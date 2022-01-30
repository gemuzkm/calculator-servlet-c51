package by.tms.servlet.Calculator;

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

@WebServlet(urlPatterns = "/history", name = "HistoryServlet")
public class HistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CalculatorService calculatorService = new CalculatorService();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        StringBuilder historyUser = new StringBuilder();
        historyUser.append(calculatorService.printHistory(user.getLogin()));

        req.setAttribute("msgHistoryUser", historyUser.toString());
        req.getServletContext().getRequestDispatcher(Constants.HISTORY_LINK_JSP).forward(req, resp);
    }
}
