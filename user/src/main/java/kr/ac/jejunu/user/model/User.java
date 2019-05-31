package kr.ac.jejunu.user.model;

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
    private List<Comment> comments;
}
