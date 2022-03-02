package web.servlet.calculator;

import entity.Operation;
import service.ValueListHandler;
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
import java.util.List;

@WebServlet(urlPatterns = "/history", name = Constants.NAME_HISTORY_SERVLET)
public class HistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CalculatorService calculatorService = new CalculatorService();

        int page = 1;
        int recordsPerPage = 1;
        if(req.getParameter("page") != null)
            page = Integer.parseInt(req.getParameter("page"));

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        int sizeItemHistory = calculatorService.getSizeHistoryItem(user);
        int pages = sizeItemHistory / recordsPerPage;

        req.setAttribute("pages", sizeItemHistory);

        List<Operation> operationList = calculatorService.getHistory(user.getLogin());

        req.setAttribute("msgListHistoryUser", operationList);
        req.getServletContext().getRequestDispatcher(Constants.PATH_HISTORY_LINK_JSP).forward(req, resp);
    }
}
