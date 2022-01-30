package filter.UserCRUD;

import entity.User;
import filter.Constants;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter (servletNames = "UserDelServlet")
public class UserDelFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        User user = new User();

        if (session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
        } else {
            req.setAttribute("mgsError", Constants.MSG_ERROR_NO_ACCESS);
            req.getServletContext().getRequestDispatcher(Constants.HOME_LINK_JSP).forward(req, res);
        }

        if (user.getRole() != 0) {
            req.setAttribute("mgsError", Constants.MSG_ERROR_NO_ACCESS);
            req.getServletContext().getRequestDispatcher(Constants.HOME_LINK_JSP).forward(req, res);
        }

        chain.doFilter(req, res);
    }
}
