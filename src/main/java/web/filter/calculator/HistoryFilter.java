package web.filter.calculator;

import entity.User;
import service.UserService;
import web.filter.Constants;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = Constants.NAME_HISTORY_SERVLET)
public class HistoryFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String sessionID = session.getId();
        UserService userService = new UserService();

        if (session.getAttribute("user") == null) {
            res.sendRedirect(Constants.URL_HOME);
        } else if (userService.changedUserSessionID(((User) session.getAttribute("user")).getLogin(), sessionID)) {
            res.sendRedirect(Constants.URL_HOME);
        } else {
            chain.doFilter(req, res);
        }
    }
}