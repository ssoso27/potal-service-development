package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makePrepareStatement(Long id, Connection con) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM userinfo WHERE id = ?");
        preparedStatement.setLong(1, id);

        return preparedStatement;
    }
}
