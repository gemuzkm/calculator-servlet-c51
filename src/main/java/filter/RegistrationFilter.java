package filter;

import validator.ValueValidator;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = "RegistrationServlet")
public class RegistrationFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        if (req.getMethod().equals("GET")) {
            HttpSession session = req.getSession();
            if (session.getAttribute("authorized") != null) {
                req.setAttribute("informational", "No access");
                req.getServletContext().getRequestDispatcher("/pages/informational.jsp").forward(req, res);
            }
        }

        if (req.getMethod().equals("POST")) {
            ValueValidator valueValidator = new ValueValidator();

            String name = req.getParameter("name").trim();
            String login = req.getParameter("login").trim();
            String password = req.getParameter("password").trim();

            if (valueValidator.isNull(name) || valueValidator.isNull(login) || valueValidator.isNull(password)) {
                if (valueValidator.isNull(name)) {
                    req.setAttribute("msgErrorName", "Name is empty");
                }

                if (valueValidator.isNull(login)) {
                    req.setAttribute("msgErrorLogin", "Login is empty");
                }

                if (valueValidator.isNull(password)) {
                    req.setAttribute("msgErrorPassword", "Password is empty");
                }

                req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req,res);
            }

            if (valueValidator.isStringEmpty(name) || valueValidator.isStringEmpty(login) || valueValidator.isStringEmpty(password)) {
                if (valueValidator.isStringEmpty(name)) {
                    req.setAttribute("msgErrorName", "Name is empty");
                }

                if (valueValidator.isStringEmpty(login)) {
                    req.setAttribute("msgErrorLogin", "Login is empty");
                }

                if (valueValidator.isStringEmpty(password)) {
                    req.setAttribute("msgErrorPassword", "Password is empty");
                }

                req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req,res);
            }
        }

        chain.doFilter(req, res);
    }
}
