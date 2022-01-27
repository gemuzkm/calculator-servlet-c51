package by.tms.servlet;

import service.CalculatorService;

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
        CalculatorService calculatorService = new CalculatorService();
        HttpSession session = req.getSession();

        if (session.getAttribute("login") != null && session.getAttribute("authorized") != null) {
            String userLogin = session.getAttribute("login").toString();

            calculatorService.delHistory(userLogin);
            session.removeAttribute("login");
            session.removeAttribute("authorized");
            session.invalidate();

            req.setAttribute("msgLogoutResult", "Logout successfully");
            req.getServletContext().getRequestDispatcher("/pages/logout.jsp").forward(req, resp);
        } else {
//            req.setAttribute("msgLogoutResult", "You were not authorized");
//            req.getServletContext().getRequestDispatcher("/pages/logout.jsp").forward(req, resp);
            req.setAttribute("informational", "Welcome, Anonymous. You are not authorized");
            req.getServletContext().getRequestDispatcher("/pages/informational.jsp").forward(req, resp);
        }
    }
}
