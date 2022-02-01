package by.tms.servlet.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/test", loadOnStartup = 0, name = "FirstServlet") //инициализация во время запуска, размер инта, чем меньше, тем выше приоритет
public class FirstServlet extends HttpServlet {

////    AtomicInteger count = 0;
//
//    @Override
//    public void init() throws ServletException {
//        System.out.println("Hello Servlet");
//    }
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
////        count++;
//    }
//
//    @Override
//    public void destroy() {
//        super.destroy();
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");

//        resp.getWriter().println("Hello" + name + " " + age);
        req.getServletContext().getRequestDispatcher("/pages/test.jsp").forward(req,resp);
    }
}
