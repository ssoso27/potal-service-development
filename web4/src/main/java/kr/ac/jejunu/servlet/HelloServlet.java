package kr.ac.jejunu.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello")
// 서블릿을 그대로 마이그레이션 하기 위해서.
// 이 어댑터를 꽂으면, 다른 어댑터가 동작을 안 함; (디폴트는 하나봄)
//@Controller("/servlet")
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
