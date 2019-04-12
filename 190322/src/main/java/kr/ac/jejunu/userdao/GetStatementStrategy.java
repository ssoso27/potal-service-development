package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetStatementStrategy implements StatementStrategy {
    private Long id;

    public GetStatementStrategy(Long id) {
        this.id = id;
    }

    @Override
    public PreparedStatement makePrepareStatement(Connection con) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setLong(1, id);

        return preparedStatement;
    }
}
