package kr.ac.jejunu.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello")
@Slf4j
public class HelloServlet extends GenericServlet {
    @Override
    public void init() throws ServletException {
        log.info("*********** servlet init *************");
        super.init();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        log.info("*********** servlet service *************");
        res.getWriter().println("<h1> this is html tag </h1>");
    }

    @Override
    public void destroy() {
        log.info("*********** servlet destroy *************");
        super.destroy();
    }
}
