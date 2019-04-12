package kr.ac.jejunu.userdao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
public class DaoFactory {
    // 의존성을 모아놓은 클래스.
    // 추후 배포할때 얘만 바꾸면 된다.
//    public UserDao getUserDao() {
//        return new UserDao(getConnectionMaker());
//    }
//    public ConnectionMaker getConnectionMaker() {
//        return new JejuConnectionMaker();
//    }

    @Value("${db.classname}")
    private String className;
    @Value("${db.url}")
    private String url;
    @Value("${db.password}")
    private String password;
    @Value("${db.username}")
    private String username;

    @Bean
    public UserDao userDao() {
        return new UserDao(jdbcContext());
    }

    @Bean
    public JdbcTemplate jdbcContext() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new JejuConnectionMaker();
    }

    @Bean
    public DataSource dataSource() {
        // DB 정보를 다 가지고 있다!
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        try {
            dataSource.setDriverClass((Class<? extends Driver>) Class.forName(className));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e); // 현재 큰 의미가 없는 예외라서, 전파 방지를 위해 바꿔줌.
        }

        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }
}
