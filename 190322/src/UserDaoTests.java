import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserDaoTests {
    @Test
    public void testGet() throws SQLException, ClassNotFoundException {
        long id = 1L;
        String name = "허윤호";
        String password = "1234";

        DaoFactory daoFactory = new DaoFactory();
        UserDao userDao = daoFactory.getUserDao();
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

        DaoFactory daoFactory = new DaoFactory();
        UserDao userDao = daoFactory.getUserDao();
        long id = userDao.add(user);
        User resultUser = userDao.get(id);

        assertThat(resultUser.getId(), is(id));
        assertThat(resultUser.getName(), is(name));
        assertThat(resultUser.getPassword(), is(password));
    }

}
