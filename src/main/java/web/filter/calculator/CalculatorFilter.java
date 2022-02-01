package web.filter.calculator;

import entity.User;
import web.filter.Constants;
import service.UserService;
import web.validator.OperationValidator;
import web.validator.ValueValidator;

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
             if (session.getAttribute("user") == null) {
                req.setAttribute("informational", Constants.MSG_ERROR_NO_AUTHORIZED);
                req.getServletContext().getRequestDispatcher(Constants.INFORMATION_LINK_JSP).forward(req, res);
            } else if (userService.changedUserSessionID(((User) session.getAttribute("user")).getLogin(), sessionID)) {
                req.setAttribute("informational", Constants.MSG_ERROR_NO_AUTHORIZED);
                req.getServletContext().getRequestDispatcher(Constants.INFORMATION_LINK_JSP).forward(req, res);
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
                    req.setAttribute("msgErrorValueOne", Constants.MSG_ERROR_VALUE_ONE_EMPTY);
                }

                if (valueValidator.isNull(valueSecond)) {
                    req.setAttribute("msgErrorValueTwo", Constants.MSG_ERROR_VALUE_TWO_EMPTY);
                }

                if (valueValidator.isNull(operation)) {
                    req.setAttribute("msgErrorOperation", Constants.MSG_ERROR_OPERATION_EMPTY);
                }

                req.getServletContext().getRequestDispatcher(Constants.CALCULATIOR_LINK_JSP).forward(req, res);
            }

            if (!valueValidator.isNumber(valueFirst) || !valueValidator.isNumber(valueSecond) || !operationValidator.supportedOperation(operation)) {
                if (!valueValidator.isNumber(valueFirst)) {
                    req.setAttribute("msgErrorValueOne", Constants.MSG_ERROR_VALUE_ONE_NOT_NUMBER);
                }

                if (!valueValidator.isNumber(valueSecond)) {
                    req.setAttribute("msgErrorValueTwo", Constants.MSG_ERROR_VALUE_TWO_NOT_NUMBER);
                }

                if (!operationValidator.supportedOperation(operation)) {
                    req.setAttribute("msgErrorOperation", Constants.MSG_ERROR_OPERATION_UNSUPPORTED);
                }

                req.getServletContext().getRequestDispatcher(Constants.CALCULATIOR_LINK_JSP).forward(req, res);
            }
        }

        chain.doFilter(req, res);
    }
}
