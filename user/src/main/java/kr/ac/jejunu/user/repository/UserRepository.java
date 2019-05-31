package kr.ac.jejunu.user.repository;

import kr.ac.jejunu.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findAllByName(String name);

    // HQL 쿼리
    // Object 기반 쿼리. 테이블 기반이 아님!
    @Query("select distinct u from Comment c join c.user u " +
                "where c.content like concat(:content, '%')")
    List<User> findAllByContent(@Param("content") String content);
}
