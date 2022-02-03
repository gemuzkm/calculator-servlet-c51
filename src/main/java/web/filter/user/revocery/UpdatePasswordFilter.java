package web.filter.user.revocery;

import web.filter.Constants;
import web.validator.ValueValidator;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = "UpdatePasswordServlet")
public class UpdatePasswordFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        if (req.getMethod().equals("POST")) {
            ValueValidator valueValidator = new ValueValidator();
            HttpSession session = req.getSession();

            String newPassword = req.getParameter("newpassword").trim();
            String inputSecretWord = req.getParameter("recword").trim();
            String secretWord = req.getParameter("recoveryword").trim();
            session.setAttribute("recoveryword", secretWord);

            if (valueValidator.isStringEmpty(newPassword) || valueValidator.isStringEmpty(inputSecretWord) || !inputSecretWord.equals(secretWord)) {
                if (valueValidator.isNull(newPassword) || valueValidator.isStringEmpty(newPassword)) {
                    req.setAttribute("msgErrorPassword", Constants.MSG_ERROR_PASSWORD_EMPTY);
                }

                if (valueValidator.isNull(inputSecretWord) || valueValidator.isStringEmpty(inputSecretWord)) {
                    req.setAttribute("msgErrorRecoveryWord", Constants.MSG_ERROR_SERCRET_WOWRD_EMPTY);
                }

                if (!secretWord.equals(inputSecretWord)) {
                    req.setAttribute("msgErrorRecoveryWord", Constants.MSG_ERROR_SECRET_WORD_WRONG);
                }

                req.getServletContext().getRequestDispatcher(Constants.NEW_PASSWORD_LINK_JSP).forward(req, res);
                return;
            }

        }

        chain.doFilter(req, res);
    }
}
