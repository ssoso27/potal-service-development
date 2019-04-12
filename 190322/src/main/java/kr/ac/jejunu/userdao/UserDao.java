package kr.ac.jejunu.userdao;


import javax.sql.DataSource;
import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class UserDao {
    private final DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User get(Long id) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new GetStatementStrategy(id);
        return jdbcContextForGet(statementStrategy);
    }

    private User jdbcContextForGet(StatementStrategy statementStrategy) throws SQLException {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            con = dataSource.getConnection();

            preparedStatement = statementStrategy.makePrepareStatement(con);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
            }

        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return user;
    }

    public long add(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new AddStatementStrategy(user);
        return jdbcContextForAdd(statementStrategy);
    }

    private long jdbcContextForAdd(StatementStrategy statementStrategy) throws SQLException {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Long id = null;

        try {
            con = dataSource.getConnection();

            preparedStatement = statementStrategy.makePrepareStatement(con);

            preparedStatement.executeUpdate();

            id = getLasttInsertId(con);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return id;
    }

    public void update(User user) throws SQLException {
        StatementStrategy statementStrategy = new UpdateStatementStrategy(user);
        jdbcContextForUpdate(statementStrategy);
    }


    public void delete(Long id) throws SQLException {
        StatementStrategy statementStrategy = new DeleteStatementStrategy(id);
        jdbcContextForUpdate(statementStrategy);
    }

    private void jdbcContextForUpdate(StatementStrategy statementStrategy) throws SQLException {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            con = dataSource.getConnection();

            preparedStatement = statementStrategy.makePrepareStatement(con);

            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Long getLasttInsertId(Connection connection) throws SQLException {
        ResultSet resultSet = null;
        Long id = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select last_insert_id()");
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            id = resultSet.getLong(1);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return id;
    }

    Connection getConnection() throws ClassNotFoundException, SQLException {

        return dataSource.getConnection();
    }

}
