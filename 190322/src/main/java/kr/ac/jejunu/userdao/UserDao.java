package kr.ac.jejunu.userdao;


import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
//    private final ConnectionMaker connectionMaker;
    private final DataSource dataSource;
    // 의존성을 외부로 떠넘김
//    public UserDao(ConnectionMaker connectionMaker) {
//        this.connectionMaker = connectionMaker;
//    }
    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User get(Long id) throws ClassNotFoundException, SQLException {
//        Connection con = connectionMaker.getConnection();
        Connection con = dataSource.getConnection();

        PreparedStatement preparedStatement = con.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setLong(1, id);;
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next(); // RDB의 커서 옮김.

        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        resultSet.close(); // 첫번째 close
        preparedStatement.close(); // 두번째 close
        con.close(); // 마지막 close. connection close하면 위에 애들도 다 close 되지만, 나중에 복잡해질때?? 문제 생길 수 있나봄.
        return user;
    }

    public long add(User user) throws ClassNotFoundException, SQLException {
//        Connection con = connectionMaker.getConnection();
        Connection con = dataSource.getConnection();

        PreparedStatement preparedStatement = con.prepareStatement("insert into userinfo(name, password) values (?, ?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());

        preparedStatement.executeUpdate();

        preparedStatement = con.prepareStatement("select last_insert_id()");
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        long id = resultSet.getLong(1);

        resultSet.close();
        preparedStatement.close();
        con.close();

        return id;
    }

    Connection getConnection() throws ClassNotFoundException, SQLException {

//        return connectionMaker.getConnection();
        return dataSource.getConnection();
    }

}
