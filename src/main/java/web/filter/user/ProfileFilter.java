package web.filter.user;

import entity.User;
import web.filter.Constants;
import web.validator.UserValidator;
import web.validator.ValueValidator;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = Constants.NAME_PROFILE_SERVLET)
public class ProfileFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        User user = new User();

        if (session.getAttribute("user") == null) {
            session.setAttribute("msgErrorNoAccess", Constants.MSG_ERROR_NO_ACCESS);
            req.getServletContext().getRequestDispatcher(Constants.PATH_PROFILE_USER_LINK_JSP).forward(req, res);
        }

        chain.doFilter(req, res);
    }
}
