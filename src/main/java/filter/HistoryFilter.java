package filter;

import service.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = "HistoryServlet")
public class HistoryFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String sessionID = session.getId();
        UserService userService = new UserService();

        if (session.getAttribute("login") == null) {
            req.setAttribute("informational", "Welcome, Anonymous. You are not authorized");
            req.getServletContext().getRequestDispatcher("/pages/informational.jsp").forward(req, res);
        } else if (userService.changedUserSessionID(session.getAttribute("login").toString(), sessionID)) {
            req.setAttribute("informational", "Welcome, Anonymous. You are not authorized");
            req.getServletContext().getRequestDispatcher("/pages/informational.jsp").forward(req, res);
        }
        chain.doFilter(req, res);
    }
}
