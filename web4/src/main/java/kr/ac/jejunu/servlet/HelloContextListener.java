package kr.ac.jejunu.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Slf4j
public class HelloContextListener implements ServletContextListener {
    // 듣고 있다가 context가 초기화 될때
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("*********context init");
    }

    // context가 destory 될때
    // tomcat 서버는 안뜸; 아마 context destroy 전에 server destroy 하는듯.
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("*********context destroy");
    }
}
