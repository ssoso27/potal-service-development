package kr.ac.jejunu.user.controller;

import kr.ac.jejunu.user.model.User;
import kr.ac.jejunu.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/list")
    public List<User> list() {
       return userRepository.findAll();
    }

    @GetMapping("/listByName/{name}")
    public List<User> listByName(@PathVariable("name") String name) {
        return userRepository.findAllByName(name);
    }

    @GetMapping("/listByContent/{content}")
    public List<User> listByCommentContent(@PathVariable("content") String content) {
        return userRepository.findAllByContent(content);
    }
}
