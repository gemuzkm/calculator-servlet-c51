package filter;

import validator.UserValidator;
import validator.ValueValidator;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = "LoginServlet")
public class LoginFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        if (req.getMethod().equals("GET")) {
            HttpSession session = req.getSession();
            if (session.getAttribute("user") != null) {
                req.setAttribute("mgsError", "No access");
                req.getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, res);
            }
        }

        if (req.getMethod().equals("POST")) {
            ValueValidator valueValidator = new ValueValidator();
            UserValidator userValidator = new UserValidator();

            if (req.getMethod().equalsIgnoreCase("POST")) {
                String login = req.getParameter("login").trim();
                String password = req.getParameter("password").trim();

                if (valueValidator.isNull(login) || valueValidator.isNull(password)) {
                    if (valueValidator.isNull(login)) {
                        req.setAttribute("msgErrorLogin", "Login is empty");
                    }

                    if (valueValidator.isNull(password)) {
                        req.setAttribute("msgErrorPassword", "Password is empty");
                    }

                    req.getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, res);
                }

                if (valueValidator.isStringEmpty(login) || valueValidator.isStringEmpty(password)) {
                    if (valueValidator.isStringEmpty(login)) {
                        req.setAttribute("msgErrorLogin", "Login is empty");
                    }

                    if (valueValidator.isStringEmpty(password)) {
                        req.setAttribute("msgErrorPassword", "Password is empty");
                    }

                    req.getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, res);
                }

                if (!userValidator.existsUser(login)) {
                    req.setAttribute("msgErrorUser", "User not found");

                    req.getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, res);
                }

                if (userValidator.validUserPassword(login, password) == null) {
                    req.setAttribute("msgErrorLoginPassword", "Login or password error");

                    req.getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, res);
                }
            }
        }
        chain.doFilter(req, res);
    }
}
