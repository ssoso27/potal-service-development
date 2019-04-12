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
            String sql = "select * from userinfo where id = ?";
            Object[] params = new Object[]{id};

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1, params[i]);
            }

            return preparedStatement;
        };

        return jdbcContext.jdbcContextForGet(statementStrategy);
    }

    public long add(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = con -> {
            String sql = "insert into userinfo(name, password) values (?, ?)";
            Object[] params = new Object[]{user.getName(), user.getPassword()};

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1, params[i]);
            }

            return preparedStatement;
        };

        return jdbcContext.jdbcContextForAdd(statementStrategy);
    }

    public void update(User user) throws SQLException {
        StatementStrategy statementStrategy = con -> {
            String sql = "UPDATE userinfo SET name=?, password=? WHERE id=?";
            Object[] params = new Object[]{user.getName(), user.getPassword(), user.getId()};

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1, params[i]);
            }

            return preparedStatement;
        };

        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }


    public void delete(Long id) throws SQLException {
        StatementStrategy statementStrategy = con -> {
            String sql = "DELETE FROM userinfo WHERE id = ?";
            Object[] params = new Object[]{id};

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1, params[i]);
            }

            return preparedStatement;
        };

        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }

    Connection getConnection() throws ClassNotFoundException, SQLException {

        return jdbcContext.dataSource.getConnection();
    }

}
