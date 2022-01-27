package filter;

import validator.OperationValidator;
import validator.ValueValidator;

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

        if (req.getMethod().equals("POST")) {
            ValueValidator valueValidator = new ValueValidator();
            OperationValidator operationValidator = new OperationValidator();

            String valueFirst = req.getParameter("value1");
            String valueSecond = req.getParameter("value2");
            String operation = req.getParameter("operation");

            if (valueValidator.isNull(valueFirst) || valueValidator.isNull(valueSecond) || valueValidator.isNull(operation)) {
                HttpSession session = req.getSession();
                session.setAttribute("msgError", "Incorrect parameters");
            } else if (!valueValidator.isNumber(valueFirst) || !valueValidator.isNumber(valueSecond)) {
                HttpSession session = req.getSession();
                session.setAttribute("msgError", "Transmitted parameters are not numbers");
            } else if (!operationValidator.supportedOperation(operation)) {
                HttpSession session = req.getSession();
                session.setAttribute("msgError", "Operation unsupported");
            } else {
                chain.doFilter(req, res);
            }
        }
    }
}
