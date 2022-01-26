package filter;

import validator.OperationValidation;
import validator.ValueValidation;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = "CalculatorServlet")
public class CalculatorFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        //        <p>${requestScope.message}</p> - SSR, page scope

        if (req.getMethod().equals("POST")) {
            ValueValidation valueValidation = new ValueValidation();
            OperationValidation operationValidation = new OperationValidation();

            String valueFirst = req.getParameter("value1");
            String valueSecond = req.getParameter("value2");
            String operation = req.getParameter("operation");

            if (valueValidation.isNull(valueFirst) || valueValidation.isNull(valueSecond) || valueValidation.isNull(operation)) {
                HttpSession session = req.getSession();
                session.setAttribute("msgError", "Incorrect parameters");
            } else if (!valueValidation.isNumber(valueFirst) || !valueValidation.isNumber(valueSecond)) {
                HttpSession session = req.getSession();
                session.setAttribute("msgError", "Transmitted parameters are not numbers");
            } else if (!operationValidation.supportedOperation(operation)) {
                HttpSession session = req.getSession();
                session.setAttribute("msgError", "Operation unsupported");
            } else {
                chain.doFilter(req, res);
            }
        }
    }
}
