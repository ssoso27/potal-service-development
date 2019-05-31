package kr.ac.jejunu.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "userinfo") // Table명이랑  Object명 다르니까 적어줌
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String password;

    @OneToMany
    @JoinColumn(name = "userinfo_id")
//    @JsonIgnore // Json 생성을 안함.
    @JsonIgnoreProperties(value={"user"}) // json 생성은 할건데, 이 오브젝트 하위의 depth를 중지시킬거야.
    private List<Comment> comments;
}
