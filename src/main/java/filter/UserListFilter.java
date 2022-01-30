package filter;

import entity.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = "UserListServlet")
public class UserListFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        User user = new User();

        if (session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
        } else {
            req.setAttribute("mgsError", "No access");
            req.getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, res);
        }

        if (user.getRole() != 0) {
            req.setAttribute("mgsError", "No access");
            req.getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, res);
        }

        chain.doFilter(req, res);
    }
}
