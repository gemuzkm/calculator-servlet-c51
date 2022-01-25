package filter;

import validator.OperationValidation;
import validator.ValueValidation;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "CalculatorServlet")
public class CalculatorFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        if (req.getMethod().equals("POST")) {
//
//        }

        ValueValidation valueValidation = new ValueValidation();
        OperationValidation operationValidation = new OperationValidation();

        String valueFirst = req.getParameter("value1");
        String valueSecond = req.getParameter("value2");
        String operation = req.getParameter("operation");

        if (valueValidation.isNull(valueFirst) || valueValidation.isNull(valueSecond) || valueValidation.isNull(operation)) {
            res.getWriter().println("Incorrect parameters");
        } else if (!valueValidation.isNumber(valueFirst) || !valueValidation.isNumber(valueSecond)) {
            res.getWriter().println("Transmitted parameters are not numbers");
        } else if (!operationValidation.supportedOperation(operation)) {
            res.getWriter().println("Operation unsupported");
        } else {
            chain.doFilter(req, res);
        }
    }
}
