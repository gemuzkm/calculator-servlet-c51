package filter.user.crud;

import entity.User;
import filter.Constants;
import validator.ValueValidator;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = "UserCreateServlet")
public class UserCreateFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        if (req.getMethod().equals("GET")) {
            HttpSession session = req.getSession();

            if (session.getAttribute("user") != null) {
                User user = (User) session.getAttribute("user");
                if (user.getRole() != 0) {
                    req.setAttribute("informational", Constants.MSG_ERROR_NO_ACCESS);
                    req.getServletContext().getRequestDispatcher(Constants.INFORMATION_LINK_JSP).forward(req, res);
                }
            }
        }

        if (req.getMethod().equals("POST")) {
            ValueValidator valueValidator = new ValueValidator();

            String name = req.getParameter("name").trim();
            String login = req.getParameter("login").trim();
            String password = req.getParameter("password").trim();

            if (valueValidator.isNull(name) || valueValidator.isNull(login) || valueValidator.isNull(password)) {
                if (valueValidator.isNull(name)) {
                    req.setAttribute("msgErrorName", Constants.MSG_ERROR_NAME_EMPTY);
                }

                if (valueValidator.isNull(login)) {
                    req.setAttribute("msgErrorLogin", Constants.MSG_ERROR_LOGIN_EMPTY);
                }

                if (valueValidator.isNull(password)) {
                    req.setAttribute("msgErrorPassword", Constants.MSG_ERROR_PASSWORD_EMPTY);
                }

                req.getServletContext().getRequestDispatcher(Constants.CREATE_USER_LINK_JSP).forward(req,res);
            }

            if (valueValidator.isStringEmpty(name) || valueValidator.isStringEmpty(login) || valueValidator.isStringEmpty(password)) {
                if (valueValidator.isStringEmpty(name)) {
                    req.setAttribute("msgErrorName", Constants.MSG_ERROR_NAME_EMPTY);
                }

                if (valueValidator.isStringEmpty(login)) {
                    req.setAttribute("msgErrorLogin", Constants.MSG_ERROR_LOGIN_EMPTY);
                }

                if (valueValidator.isStringEmpty(password)) {
                    req.setAttribute("msgErrorPassword", Constants.MSG_ERROR_PASSWORD_EMPTY);
                }

                req.getServletContext().getRequestDispatcher(Constants.CREATE_USER_LINK_JSP).forward(req,res);
            }
        }

        chain.doFilter(req, res);
    }
}
