package filter;

import validator.UserValidation;
import validator.ValueValidation;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "LoginServlet")
public class LoginFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        if (req.getMethod().equals("POST")) {
            ValueValidation valueValidation = new ValueValidation();
            UserValidation userValidation = new UserValidation();

            if (req.getMethod().equalsIgnoreCase("POST")) {
                String login = req.getParameter("login");
                String password = req.getParameter("password");

                if (valueValidation.isNull(login) || valueValidation.isNull(password)) {
                    if (valueValidation.isNull(login)) {
                        req.setAttribute("msgErrorLogin", "Login is empty");
                    }

                    if (valueValidation.isNull(password)) {
                        req.setAttribute("msgErrorPassword", "Password is empty");
                    }

                    req.getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, res);
                }

                if (valueValidation.isStringEmpty(login) || valueValidation.isStringEmpty(password)) {
                    if (valueValidation.isStringEmpty(login)) {
                        req.setAttribute("msgErrorLogin", "Login is empty");
                    }

                    if (valueValidation.isStringEmpty(password)) {
                        req.setAttribute("msgErrorPassword", "Password is empty");
                    }

                    req.getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, res);
                }

                if (!userValidation.existsUser(login)) {
                    req.setAttribute("msgErrorUser", "User not found");

                    req.getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, res);
                }

                if (userValidation.validUserPassword(login, password) == null) {
                    req.setAttribute("msgErrorLoginPassword", "Login or password error");

                    req.getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, res);
                }
            }
//            if (valueValidation.isNull(login) || valueValidation.isNull(password)) {
//                res.getWriter().println("Incorrect parameters");
//            } else if (valueValidation.isStringEmpty(login) || valueValidation.isStringEmpty(password)) {
//                res.getWriter().println("Incorrect parameters");
//            } else if (!userValidation.existsUser(login)) {
//                res.getWriter().println("User not found.");
//            }
        }
        chain.doFilter(req, res);
    }
}
