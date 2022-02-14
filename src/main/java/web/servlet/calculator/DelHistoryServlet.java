package web.servlet.calculator;

import service.CalculatorService;
import web.servlet.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delhistory", name = "DelHistoryServlet")
public class DelHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CalculatorService calculatorService = new CalculatorService();

        String login = req.getParameter("login");
        int idItemHistory = Integer.parseInt(req.getParameter("idItemHistory"));

        calculatorService.delHistory(login, idItemHistory - 1);

        resp.sendRedirect(Constants.HISTORY_LINK);
    }
}
