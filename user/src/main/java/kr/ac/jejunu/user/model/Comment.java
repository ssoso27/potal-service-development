package kr.ac.jejunu.user.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Comment {
    private Integer id;
    private User user;
    private String content;
}
