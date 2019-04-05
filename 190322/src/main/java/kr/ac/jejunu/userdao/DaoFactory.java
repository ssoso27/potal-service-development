package kr.ac.jejunu.userdao;

public class DaoFactory {
    // 의존성을 모아놓은 클래스.
    // 추후 배포할때 얘만 바꾸면 된다.
    
    public UserDao getUserDao() {
        return new UserDao(getConnectionMaker());
    }

    public ConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }
}
