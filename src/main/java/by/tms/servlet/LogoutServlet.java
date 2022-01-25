package by.tms.servlet;

import service.HistoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HistoryService historyService = new HistoryService();
        HttpSession session = req.getSession();

        if (session.getAttribute("login") != null) {
            String userLogin = session.getAttribute("login").toString();

            historyService.delHistory(userLogin);
            session.removeAttribute("login");
            session.invalidate();
            resp.getWriter().println("Logout successfully");
        } else {
            resp.getWriter().println("You were not authorized");
        }
    }
}
