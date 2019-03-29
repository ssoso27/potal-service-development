import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserDaoTests {
    @Test
    public void testJejuGet() throws SQLException, ClassNotFoundException {
        long id = 1L;
        String name = "허윤호";
        String password = "1234";

        UserDao userDao = new JejuUserDao();
        User user = userDao.get(id);

        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void testJejuAdd() throws SQLException, ClassNotFoundException {
        String name = "소히";
        String password = "sosohehe";

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        UserDao userDao = new JejuUserDao();
        long id = userDao.add(user);
        User resultUser = userDao.get(id);

        assertThat(resultUser.getId(), is(id));
        assertThat(resultUser.getName(), is(name));
        assertThat(resultUser.getPassword(), is(password));
    }

    @Test
    public void testHallaGet() throws SQLException, ClassNotFoundException {
        long id = 1L;
        String name = "헐크";
        String password = "1111";

        UserDao userDao = new HallaUserDao();
        User user = userDao.get(id);

        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }
}
