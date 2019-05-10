package kr.ac.jejunu.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// RequestMethod핸들러매핑-RequestMethod핸들러어댑터

@Controller
@RequestMapping("/annotation") // 클래스나 메소드에 다 넣을 수 있음. class에 있다면, /annotation 하이라키 구조가 나오겠지?
public class AnnotationController {

    // @RequestMapping 을 받은 애가 핸들러가 됨.
    @RequestMapping("/hello") // url : /annotation/hello
    public String hello() {
        return "helloworld"; // InternalResourceViewReslover -> hello.jsp 찾아감 -> 띄움
    }

    @RequestMapping("/hello2") // url : /annotation/hello2
    public ModelAndView hello2() {
        ModelAndView modelAndView = new ModelAndView("helloworld"); // view mapping
        modelAndView.addObject("hello", "annotation hi");
        return modelAndView; // InternalResourceViewReslover -> helloworld.jsp 찾아감 -> 띄움
    }
}
