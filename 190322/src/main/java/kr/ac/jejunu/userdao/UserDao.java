package kr.ac.jejunu.userdao;


import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User get(Long id) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = con -> {
            PreparedStatement preparedStatement = con.prepareStatement("select * from userinfo where id = ?");
            preparedStatement.setLong(1, id);

            return preparedStatement;
        };

        return jdbcContext.jdbcContextForGet(statementStrategy);
    }

    public long add(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = con -> {
            PreparedStatement preparedStatement = con.prepareStatement("insert into userinfo(name, password) values (?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());

            return preparedStatement;
        };

        return jdbcContext.jdbcContextForAdd(statementStrategy);
    }

    public void update(User user) throws SQLException {
        StatementStrategy statementStrategy = con -> {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE userinfo SET name=?, password=? WHERE id=?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setLong(3, user.getId());

            return preparedStatement;
        };

        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }


    public void delete(Long id) throws SQLException {
        StatementStrategy statementStrategy = con -> {
            PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM userinfo WHERE id = ?");
            preparedStatement.setLong(1, id);

            return preparedStatement;
        };

        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }

    Connection getConnection() throws ClassNotFoundException, SQLException {

        return jdbcContext.dataSource.getConnection();
    }

}
