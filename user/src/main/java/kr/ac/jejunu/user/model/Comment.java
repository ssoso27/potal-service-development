package kr.ac.jejunu.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne // n:1 관계 표시
    @JoinColumn(name = "userinfo_id") // 뭘로 쪼인할건지 알려줘야함
    private User user;

    private String content;
}
