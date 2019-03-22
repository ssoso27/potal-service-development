import java.sql.*;

public class UserDao {
    public User get(Long id) throws ClassNotFoundException, SQLException {
        // DB가 뭐야? mysql
        // 어딨어? 알려줄게...

        // 드라이버 로드
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 커넥션 맺고 (=> 맺어지면 소켓통신에 들어감. TCP 프로토콜 아래에서 돌아감)
        // Connection con = DriverManager.getConnection("jdbc:mysql://172.18.108.128/jeju?serverTimezone=UTC", "portal", "portaljejunu");
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.54/jeju?serverTimezone=UTC",
                "jeju", "jejupw");
        // SQL 쿼리도 만들고
        /// Statement - 고정 쿼리. -> 만약 id 1, 2, 3을 넣는다면, 쿼리 파싱 3번 필요.
        /// preparedStatement - 변동 쿼리. 나중에 매핑 가능. -> 만약 id 1, 2, 3을 넣는대도, 쿼리 파싱 1번만 필요.
        PreparedStatement preparedStatement = con.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setLong(1, id);;
        // 쿼리 실행하고
        /// 이제 쿼리 날린거임!!! -> resultSet에 결과 들어옴
        ResultSet resultSet = preparedStatement.executeQuery();
        // 실행된 쿼리를, 오브젝트에 매핑하고
        /// resultSet은 하나일수도, 여럿일수도 있음.
        resultSet.next(); // RDB의 커서 옮김.
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        // 자원들 해지하고
        /// 아래의 친구들은, 다 재활용 가능함. stream 기반의 object들. stream이 연결되어 있어서 다 close 해주어야함.
        resultSet.close(); // 첫번째 close
        preparedStatement.close(); // 두번째 close
        con.close(); // 마지막 close. connection close하면 위에 애들도 다 close 되지만, 나중에 복잡해질때?? 문제 생길 수 있나봄.
        // 값 리턴
        return user;
    }
}
