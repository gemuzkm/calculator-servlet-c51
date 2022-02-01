package web.filter.user.revocery;

import web.filter.Constants;
import web.validator.ValueValidator;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "RecoveryServlet")
public class RecoveryFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        if (req.getMethod().equals("POST")) {
            ValueValidator valueValidator = new ValueValidator();

            String login = req.getParameter("login").trim();

            if (valueValidator.isNull(login) || valueValidator.isStringEmpty(login)) {
                req.setAttribute("msgErrorLogin", Constants.MSG_ERROR_LOGIN_EMPTY);
                req.getServletContext().getRequestDispatcher(Constants.RECOVERY_USER_LINK_JSP).forward(req, res);
            }
        }
        chain.doFilter(req, res);
    }
}
