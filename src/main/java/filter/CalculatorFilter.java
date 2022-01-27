package filter;

import service.UserService;
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
        UserService userService = new UserService();
        HttpSession session = req.getSession();
        String sessionID = session.getId();

        if (req.getMethod().equals("GET")) {
            if (session.getAttribute("login") == null || session.getAttribute("authorized") == null) {
                req.setAttribute("informational", "Welcome, Anonymous. You are not authorized");
                req.getServletContext().getRequestDispatcher("/pages/informational.jsp").forward(req, res);
            } else if (userService.changedUserSessionID(session.getAttribute("login").toString(), sessionID)) {
                req.setAttribute("informational", "Welcome, Anonymous. You are not authorized");
                req.getServletContext().getRequestDispatcher("/pages/informational.jsp").forward(req, res);
            }
        }

        if (req.getMethod().equals("POST")) {
            ValueValidator valueValidator = new ValueValidator();
            OperationValidator operationValidator = new OperationValidator();

            String valueFirst = req.getParameter("value1");
            String valueSecond = req.getParameter("value2");
            String operation = req.getParameter("operation");

            if (valueValidator.isNull(valueFirst) || valueValidator.isNull(valueSecond) || valueValidator.isNull(operation)) {
                if (valueValidator.isNull(valueFirst)) {
                    req.setAttribute("msgErrorValueOne", "Value1 is empty");
                }

                if (valueValidator.isNull(valueSecond)) {
                    req.setAttribute("msgErrorValueTwo", "Value2 is empty");
                }

                if (valueValidator.isNull(operation)) {
                    req.setAttribute("msgErrorOperation", "Operation is empty");
                }

                req.getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, res);
            }

            if (!valueValidator.isNumber(valueFirst) || !valueValidator.isNumber(valueSecond) || !operationValidator.supportedOperation(operation)) {
                if (!valueValidator.isNumber(valueFirst)) {
                    req.setAttribute("msgErrorValueOne", "Value1 not a number");
                }

                if (!valueValidator.isNumber(valueSecond)) {
                    req.setAttribute("msgErrorValueTwo", "Value2 not a number");
                }

                if (!operationValidator.supportedOperation(operation)) {
                    req.setAttribute("msgErrorOperation", "Operation unsupported");
                }

                req.getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, res);
            }
        }

        chain.doFilter(req, res);
    }
}
