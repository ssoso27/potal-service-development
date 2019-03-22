import java.sql.*;

public class UserDao {
    public User get(Long id) throws ClassNotFoundException, SQLException {
        // DB가 뭐야? mysql
        // 어딨어? 알려줄게...

        // 드라이버 로드
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 커넥션 맺고
        // Connection con = DriverManager.getConnection("jdbc:mysql://172.18.108.128/jeju?serverTimezone=UTC", "portal", "portaljejunu");
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.54/jeju?serverTimezone=UTC",
                "jeju", "jejupw");
        // SQL 쿼리도 만들고
        PreparedStatement preparedStatement = con.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setLong(1, id);;
        // 쿼리 실행하고
        ResultSet resultSet = preparedStatement.executeQuery();
        // 실행된 쿼리를, 오브젝트에 매핑하고
        resultSet.next();
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        // 자원들 해지하고
        resultSet.close();
        preparedStatement.close();
        con.close();
        // 값 리턴
        return user;
    }
}
