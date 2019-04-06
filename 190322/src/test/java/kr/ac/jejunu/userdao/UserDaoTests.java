package kr.ac.jejunu.userdao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.nullValue;

public class UserDaoTests {
    private UserDao userDao;

    @Before
    public void setup() {
//        DaoFactory daoFactory = new DaoFactory();
//        UserDao userDao = daoFactory.getUserDao();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        userDao = applicationContext.getBean("userDao", UserDao.class);
    }

    @Test
    public void testGet() throws SQLException, ClassNotFoundException {
        long id = 1L;
        String name = "허윤호";
        String password = "1234";

        User user = userDao.get(id);

        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void testAdd() throws SQLException, ClassNotFoundException {
        String name = "소히";
        String password = "sosohehe";

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        long id = userDao.add(user);
        User resultUser = userDao.get(id);

        assertThat(resultUser.getId(), is(id));
        assertThat(resultUser.getName(), is(name));
        assertThat(resultUser.getPassword(), is(password));
    }

    @Test
    public void testUpdate() throws SQLException, ClassNotFoundException {
        // 추가하고,
        String name = "소히";
        String password = "sosohehe";
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        Long id = userDao.add(user);
        user.setId(id);

        // 변경하고,
        String newName = "쏘이";
        String newPw = "hehesoso";
        user.setName(newName);
        user.setPassword(newPw);
        userDao.update(user);

        // 변경된거 확인
        User result = userDao.get(user.getId());

        assertThat(result.getId(), is(id));
        assertThat(result.getName(), is(newName));
        assertThat(result.getPassword(), is(newPw));
    }

    @Test
    public void testDelete() throws SQLException, ClassNotFoundException {
        // 추가하고,
        String name = "소히";
        String password = "sosohehe";
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        Long id = userDao.add(user);
        user.setId(id);

        // 삭제하고,
        userDao.delete(id);

        // 삭제된거 확인
        User result = userDao.get(id);
        assertThat(result, nullValue());
    }

}
