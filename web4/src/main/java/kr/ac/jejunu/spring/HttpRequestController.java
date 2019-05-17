package kr.ac.jejunu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller("/request")
public class HttpRequestController implements HttpRequestHandler {
    // Simple과 달리, return이 void다.
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<h1>hi</h1>"); // servlet처럼, html 하드코딩 해줘야함.
        // view가 없는 servlet에서 사용
    }
}
