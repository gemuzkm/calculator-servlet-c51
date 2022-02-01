package web.servlet.calculator;

import web.servlet.Constants;
import entity.Operation;
import entity.User;
import entity.ValueOne;
import entity.ValueTwo;
import service.CalculatorService;

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
        req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_LINK_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CalculatorService calculatorService = new CalculatorService();

        String valueFirst = req.getParameter("value1");
        String valueSecond = req.getParameter("value2");
        String operationValue = req.getParameter("operation");
        User user = (User) session.getAttribute("user");

        ValueOne valueOne = new ValueOne(Double.parseDouble(valueFirst));
        ValueTwo valueTwo = new ValueTwo(Double.parseDouble(valueSecond));
        Operation operation = new Operation(operationValue);

        String resultOperation = calculatorService.getResult(valueOne, valueTwo, operation, user);

        req.setAttribute("result", "Result = " + resultOperation);
        req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_LINK_JSP).forward(req, resp);
    }
}

