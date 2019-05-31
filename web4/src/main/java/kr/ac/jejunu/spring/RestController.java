package kr.ac.jejunu.spring;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody // 얘가 없으면? -> resolver를 탄다
    public User get(@PathVariable("id") Integer id) {
        return User.builder().id(id).name("sohee").password("1212").build();
    }

    @PostMapping
    @ResponseBody
    public User add(@RequestBody User user) {
        return user;
    }
}
