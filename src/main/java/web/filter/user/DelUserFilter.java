package web.filter.user;

import entity.User;
import web.filter.Constants;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter (servletNames = Constants.NAME_DEL_USER_SERVLET)
public class DelUserFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        User user = new User();

        if (session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
        } else {
            req.setAttribute("mgsError", Constants.MSG_ERROR_NO_ACCESS);
            req.getServletContext().getRequestDispatcher(Constants.PATH_HOME_LINK_JSP).forward(req, res);
        }

        if (user.getRole() != 1) {
            req.setAttribute("mgsError", Constants.MSG_ERROR_NO_ACCESS);
            req.getServletContext().getRequestDispatcher(Constants.PATH_HOME_LINK_JSP).forward(req, res);
        }

        if (user.getLogin().equals(req.getParameter("login")))  {
           session.setAttribute("msgError", Constants.MSG_ERROR_NO_DEL_YOURSELF);
           res.sendRedirect(Constants.URL_USER_LIST);
           return;
        }

        chain.doFilter(req, res);
    }
}
