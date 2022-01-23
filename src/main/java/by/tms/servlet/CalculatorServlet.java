package by.tms.servlet;

import service.CalculatorService;
import storage.UserStorageInMemory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/calculator", name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserStorageInMemory userStorageInMemory = new UserStorageInMemory();

        String valueFirst = req.getParameter("value1");
        String valueSecond = req.getParameter("value2");
        String operation = req.getParameter("operation");

        CalculatorService calculatorService = new CalculatorService(valueFirst, valueSecond, operation);

        resp.getWriter().println(calculatorService.getResult());
    }
}

