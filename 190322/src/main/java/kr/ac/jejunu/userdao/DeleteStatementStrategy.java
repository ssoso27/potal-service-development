package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStatementStrategy implements StatementStrategy {
    Long id = null;

    public DeleteStatementStrategy(Long id) {
        this.id = id;
    }

    @Override
    public PreparedStatement makePrepareStatement(Connection con) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM userinfo WHERE id = ?");
        preparedStatement.setLong(1, id);

        return preparedStatement;
    }
}
