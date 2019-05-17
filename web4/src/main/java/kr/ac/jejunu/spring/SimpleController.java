package kr.ac.jejunu.spring;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 스프링에서는 bean 이름을 path로 지정함.
// 이 bean 이름을 가지고 mapping을 진행함. (by Handler Mapping)
// (Handler Mapping의 종류?는 servlet 정의한 xml에서 정의) -
/// default : BeanNameUrlHandlerMapping, RequestMethodHandlerMappgng
// ViewResolver가 bean이름.jsp 이라는 view에 연결시켜줌
@org.springframework.stereotype.Controller("/helloworld")
public class SimpleController implements Controller { // 이 컨트롤러 자체가 하나의 Adapter.
    // Handler Adapter에서 handleRequest method 수행
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView(); // 연결할 view 기본 : bean이름.jsp
        modelAndView.addObject("hello", "hi sohi!");
        return modelAndView;
    }
}
