package kr.ac.jejunu.spring;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

// web.xml 없이 하기!
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // servletContext : 이미 정의되어 있음. 여기다가 서블릿 넣자!
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext(); // context 만들고
        context.scan("kr.ac.jejunu"); // context에다가 얘(전부)를 스캔할 수 있도록 지정 -> @bean @configraution 등록
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("dipatcher"
                , new DispatcherServlet(context)); // annotation으로 정의한 config 꽂기
        servletRegistration.setLoadOnStartup(1); // load startup 지정
        servletRegistration.addMapping("/"); // 어떤 url과 매핑? -> 모든 url 꽂도록 지정
    }
}
