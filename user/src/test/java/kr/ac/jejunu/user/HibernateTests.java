package kr.ac.jejunu.user;

import kr.ac.jejunu.user.model.Comment;
import kr.ac.jejunu.user.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class HibernateTests {
    // 세션 단위는 하나의 커넥션...이라고 일단 봐두지만, 동일하진 않다.
    // 세션 팩토리 : 커넥션 관리해주는 애.
    static SessionFactory sessionFactory;

    @BeforeClass
    public static void setup() {
        // 세션팩토리 가져오기!
        /// 1. configuration 을 통해서 가져올거니까 config 만듬
        /// 2. registry 등록
        /// 3. config에서 registry를 통해 가져옴

        Configuration configuration = new Configuration()
                .configure("jejunu.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Comment.class);

        // 서비스를 활용할 떄 어떻게 할 것인가? 를 등록하는 역할
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()) // 아까 만든 config 가져와서 등록
                    .build();

        try {
            sessionFactory = configuration.buildSessionFactory(registry);
        } catch (HibernateException e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @Test
    public void getUser() {
        // DB의 유저를 가져오는 로직

        // 1. 세션 얻어오기
        Session session = sessionFactory.openSession();
        // 2. 오브젝트 얻어오기 (query 생성)
        User user = session.get(User.class, 1);

        assertThat(user.getName(), is("양소희"));
        assertThat(user.getPassword(), is("pass12"));

        session.close();
    }

    @Test
    public void saveUser() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin(); // transaction 시작 (트랜잭션 지원하는 버전 DB 사용해야함!)
        try {
            User user = User.builder().name("abcd").password("111").build();
            session.save(user); // 쿼리 생성

            User saveUser = session.get(User.class, user.getId()); // 쿼리 안생성. 캐시 씀.
            assertThat(saveUser.getName(), is(user.getName()));
            assertThat(saveUser.getPassword(), is(user.getPassword()));

            session.getTransaction().commit(); // 트랜잭션 커밋
        } catch (HibernateException e) {
            session.getTransaction().rollback(); // 트랜잭션 롤백
        } finally {
            session.close();
        }
    }

    public static void destory() {
        sessionFactory.close();
    }
}
