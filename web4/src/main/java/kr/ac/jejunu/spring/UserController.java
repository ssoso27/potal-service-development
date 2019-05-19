package kr.ac.jejunu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/get")
    public ModelAndView get(@RequestParam("id") Integer id, @RequestParam("name") String name, HttpServletResponse response) {
        User user = User.builder().id(id).name(name).password("1234").build();

        response.addCookie(new Cookie("id", id.toString()));
        response.addCookie(new Cookie("name", name));

        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("/redirect")
    public String redirect() {
        // redirect string
        return "redirect:/user/upload";
    }

    @RequestMapping("/forward")
    public String foarward() {
        // forward string
        return "forward:/user/upload";
    }

    @RequestMapping("/model")
    public String model(User user) {
        return "user"; // view mapping
    }

    @RequestMapping("/cookie")
    public ModelAndView cookie(@CookieValue(value = "id", defaultValue = "4") Integer id, @CookieValue(value = "name", required = false) String name) {
        User user = User.builder().id(id).name(name).password("1234").build();
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping("/get/id/{id}/name/{name}")
    public ModelAndView path(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        User user = User.builder().id(id).name(name).build();
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String uploadpage() {
        return "upload";
    }

    // @RequestParam : query param이나 form이 전달해준 애들을 받아옴 (name = param 이름 혹은 value name)
    // @HttpServletRequest : 이거 하면 알아서 request가 넘어오는데, 저장한 file path를 정하기 위해 받아왔음
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        // [file 선언]
        // 저장위치와 이름을 지정하여, 특정 위치에 (임시)파일을 생성해둠
        File path = new File(
                request.getServletContext().getRealPath("/") // 실제 servlet이 돌아가는 환경을 얻고, 돌아가는 was상의 파일 위치를 가져옴
                        + "/WEB-INF/static/"
                        + file.getOriginalFilename() // 업로드 된 파일 이름
        );

        // [file write]
        // path에 파일을 output 해줌 (= 저장해줌?)
        // buffer로 한번 감싸주는 이유
        /// file Output steam만 하면, file 사이즈 만큼 file io를 일일이 태움 -> 느림
        /// buffer output stream을 만들면, buffer 사이즈 만큼의 메모리에 넣고, 걔네를 통째로 io. -> 빠름
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(file.getBytes()); // write
        bufferedOutputStream.close(); // buffer 닫아주기!

        ModelAndView modelAndView = new ModelAndView("upload");
        modelAndView.addObject("url", "/images/" + file.getOriginalFilename()); // /images/**의 위치를 디스패처 xml에서 매핑 해주어야함!
        return modelAndView;
    }

    @RequestMapping("/error")
    public void error() {
        throw new RuntimeException("runtime exception");
    }

    @ExceptionHandler(Exception.class) // 어떤 Exception이 떨어졌을때 인지도 설정할 수 있음
    public ModelAndView errorPage(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("e", e);
        return modelAndView;
    }
}
