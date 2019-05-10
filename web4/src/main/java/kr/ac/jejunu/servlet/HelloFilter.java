package kr.ac.jejunu.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("===================filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("===================filter pre"); // 앞에서 걸러주기
        chain.doFilter(request, response); // 서블릿 동작
        log.info("===================filter post"); // (서블릿 동작 끝난 후에) 뒤에서 걸러주기
    }

    @Override
    public void destroy() {
        log.info("===================filter destroy");
    }
}
