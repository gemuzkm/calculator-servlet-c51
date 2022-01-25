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
        ValueValidation valueValidation = new ValueValidation();
        UserValidation userValidation = new UserValidation();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (valueValidation.isNull(login) || valueValidation.isNull(password)) {
            //res.sendRedirect("/calculator");
            res.getWriter().println("Incorrect parameters");
        } else if (valueValidation.isStringEmpty(login) || valueValidation.isStringEmpty(password)) {
            //res.sendRedirect("/calculator");
            res.getWriter().println("Incorrect parameters");
        } else if (!userValidation.existsUser(login)) {
            //res.sendRedirect("/calculation");
            res.getWriter().println("User not found.");
        } else {
            chain.doFilter(req, res);
        }
    }
}
