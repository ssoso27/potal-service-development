package kr.ac.jejunu.user.controller;

import kr.ac.jejunu.user.model.User;
import kr.ac.jejunu.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
        List<User> all = userRepository.findAll();
        all.forEach(user -> {
            // lazy 로딩
            /// 쿼리가 필요한 그 순간에 로딩함
            /// 여기서 또 comment 가져오는 쿼리 만듬.
            user.getComments().size();
        });
        return all;
    }
}
