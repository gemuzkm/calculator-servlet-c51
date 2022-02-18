package web.servlet.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
// сервлет singelton


@WebServlet(urlPatterns = "/test", loadOnStartup = 0, name = "FirstServlet") //инициализация во время запуска, размер инта, чем меньше, тем выше приоритет
public class FirstServlet extends HttpServlet {
    CopyOnWriteArrayList onWriteArrayList = new CopyOnWriteArrayList();
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

//    private Logger log = Logger.getLogger(this.getClass().getName());
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 //       log.log(Level.INFO, "Hello");
    logger.info("Hello slf info"); //информационные
    logger.warn("Hello warn"); //обращение к несуществующим путям
    logger.error("Hello err"); //фаталити, Exception

        logger.debug("Hello debug"); //информационные сообщение при старте и тд
        logger.trace("Hello trace"); //очень подробные лог

        String name = req.getParameter("name");
        String age = req.getParameter("age");

//        resp.getWriter().println("Hello" + name + " " + age);
        req.getServletContext().getRequestDispatcher("/pages/test/test.jsp").forward(req,resp);
    }
}
