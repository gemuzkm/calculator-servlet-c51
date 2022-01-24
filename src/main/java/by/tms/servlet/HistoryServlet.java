package by.tms.servlet;

import service.HistoryService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/history")
public class HistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserService userService = new UserService();
        String sessionID = session.getId();

        if (session.getAttribute("login") == null) {
            resp.getWriter().println("Welcome, Anonymous. You are not authorized.");
        } else if (userService.changedUserSessionID(session.getAttribute("login").toString(), sessionID)) {
            resp.getWriter().println("Welcome, Anonymous. You are not authorized.");
        } else {
            HistoryService historyService = new HistoryService();
            resp.getWriter().println(historyService.printHistory(session.getAttribute("login").toString()));
        }
    }
}
