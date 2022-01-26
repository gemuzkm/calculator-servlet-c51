package filter;

import validator.ValueValidation;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "RegistrationServlet")
public class RegistrationFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        if (req.getMethod().equals("POST")) {
            ValueValidation valueValidation = new ValueValidation();

            String name = req.getParameter("name");
            String login = req.getParameter("login");
            String password = req.getParameter("password");

            if (valueValidation.isNull(name) || valueValidation.isNull(login) || valueValidation.isNull(password)) {
                if (valueValidation.isNull(name)) {
                    req.setAttribute("msgErrorName", "Name is empty");
                }

                if (valueValidation.isNull(login)) {
                    req.setAttribute("msgErrorLogin", "Login is empty");
                }

                if (valueValidation.isNull(password)) {
                    req.setAttribute("msgErrorPassword", "Password is empty");
                }

                req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req,res);
            }

            if (valueValidation.isStringEmpty(name) || valueValidation.isStringEmpty(login) || valueValidation.isStringEmpty(password)) {
                if (valueValidation.isStringEmpty(name)) {
                    req.setAttribute("msgErrorName", "Name is empty");
                }

                if (valueValidation.isStringEmpty(login)) {
                    req.setAttribute("msgErrorLogin", "Login is empty");
                }

                if (valueValidation.isStringEmpty(password)) {
                    req.setAttribute("msgErrorPassword", "Password is empty");
                }

                req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req,res);
            }

//            if (valueValidation.isNull(name) || valueValidation.isNull(login) || valueValidation.isNull(password)) {
//                req.setAttribute("message", "Incorrect parameters");
//                req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req,res);
//            }
//            if (valueValidation.isStringEmpty(name) || valueValidation.isStringEmpty(login) || valueValidation.isStringEmpty(password)) {
//                req.setAttribute("message", "Incorrect parameters");
//                req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req,res);
//            }
        }

        chain.doFilter(req, res);
    }
}
