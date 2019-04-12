package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makePrepareStatement(Object object, Connection con) throws SQLException {
        User user = (User) object;

        PreparedStatement preparedStatement = con.prepareStatement("UPDATE userinfo SET name=?, password=? WHERE id=?");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setLong(3, user.getId());

        return preparedStatement;
    }
}
