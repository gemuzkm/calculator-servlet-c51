package filter;

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
        String name = req.getParameter("username");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (name == null || login == null || password == null) {
            res.sendRedirect("/calculator");
        } else {
            super.doFilter(req, res, chain);
        }


    }
}
