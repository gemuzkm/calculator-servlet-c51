package by.tms.servlet;

import service.CalculatorService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/calculator", name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String valueFirst = req.getParameter("value1");
        String valueSecond = req.getParameter("value2");
        String operation = req.getParameter("operation");
        String userLogin = session.getAttribute("login").toString();

        CalculatorService calculatorService = new CalculatorService(valueFirst, valueSecond, operation, userLogin);

        String resultOperation = calculatorService.getResult();
        req.setAttribute("result", "Result = " + resultOperation);

        req.getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);

    }
}

