package kr.ac.jejunu.user.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User {
    private Integer id;
    private String name;
    private String password;
    private List<Comment> comments;
}
