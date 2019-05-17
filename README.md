# 포털서비스 개발방법론

## [1] 19.03.08 OT

- 보강 시간 : 일요일 2시~4시반 (아마?)

- Java, IntelliJ Enterprise license

- 서버사이드 과정. (JS는 프론트관점에서 필수임)
  - JS는 기본적으로 프로젝트 하나 만들 수 있는 정도
- 기말고사 : 특정 주제의 사이트를 프론트-서버사이드 다 개발 

- 실습 mySQL 붙여서 함

커리큘럼

- 토비의 스프링 프레임워크
- 리팩토링 과정 (날코딩 -> 프레임워크 만드는 과정) :: ~중간고사 기간
- 웹에 대한 기술
- 웹 -> 자바 기반의 웹 (스프링) 전환 

중간고사

- 시험. (리팩토리 과정?)
- 개인 PC로 코딩 후 커밋. 

기말고사 

- 개인 서비스 만들거나? 과제 주던가? => 발표
  - 평가 기준 : 내가 영업사원이라고 생각하고, 사용자에게 어떻게 어필하는지. 
- 어떤 서비스를 만들고 싶은지 미리 생각해 볼 것 

깃헙

- 매 수업때마다 커밋. 커밋 이력 보고 잘 따라오는지 평가.

수업의 목표

- 서버개발에 대한 자신감. 

---

## [2] 19.03.15

### 객체지향 디자인 패턴

#### SOLID

1. SRP

2. OCP

3. LSP

4. ISP

5. **DIP**

   각각의 Object에 대해서 의존성을 갖지 말아야 한다. (스프링의 핵심)

### TDD

**"Known To Unknown"**

하나에만 신경쓸 수 있도록. (엮인 애들 신경 ㄴㄴ)

ex) Controller 구현시에는 Controller에만 신경. Service 신경 ㄴㄴ

#### Test 코드 작성 과정

1. 테스트 클래스 생성
2. 알고 있는 사실을 코드로 작성 (ex: status = OK, result = string)
3. 빨간줄 없애기 (= 로직 구현)
   1. test 결과 mock 변수 만들기 (ex: expectedString = "hello")
   2. 모델 추가할거면 추가하고 ... 로직도 알아서 하시고... 
4. 테스트 코드 동작 

#### TDD의 목적

**모르는걸 찾아가고, 내가 뭔가 하려는 행위를 규정하기 위해서.**

- 굉장히 간단한 테스트의 경우는, 스킵하는 경우도 있다.
- 좀...사람마다 갈리는듯. 무조건 테스트 만드는 사람 vs 적당히 만드는 사람 
- 버그 발생 시 버그 수정을 위해 테스트 코드를 추가하기도 함. 

#### 단위 테스트

#### 통합 테스트



```java
// Controller Test
@Test
public void testModify() {
    // 대충 세팅... 모킹... 
    Integer Id = 1;
    
    given()
        .willReturn();
    
    mvc.perform(post("/api/modify"))
        .contentType()
        .content()
        .andExcept();
}

// Contoroller
@PostMapping("/modify")
public User modify(@RequestBody @Valid User user) { // Request Body 지정, 유효성 검사
    return userRepository.modify(user);
}
```



### 레이어드 아키텍쳐

#### Controller

- 컨트롤러에는 로직이 들어가지 않는다. 너무 무거워짐.
- 로직은 서비스에서.

#### Repository

- 레파지토리는 테스트가 굉장히 간단해서, 보통 안함.



### 사용자 관리 시스템 설계 과정

1. 요구사항 받음

2. 생각해보자 (모르는 것을 알게 논의하는게 중요!)

   - 지금 우리가 알고 있는 것?
     - 기획자의 기획서

   - 지금 우리가 모르고 있는 것? -> 의사결정을 통해 알고 있는 것으로 만들어야함
     - 결과물 뭘로 만들까?-> 웹으로 만들자! (알고 있는 것으로 됨)
     - 디자인 어떻게? -> 디자인 화면 생성! (알고 있는 것으로 됨)
     - 개발 언어, 프레임워크 등등? -> 자바로 하자. (알고 있는 것으로 됨)
     - 프론트 어떻게 할까? -> html로 ajax 쓰자 (알고 있는 것으로 됨)
     - 백 어떻게 할까? -> 자바 기반으로 서버를 개발하자. API 통신으로 하자 (알고 있는 것으로 됨)
     - 마크업 주세요 -> 마크업 만듬 (알고 있는 것으로 됨)
     - 서버에서의 데이터 통신 
     - url 이렇게 해보자 
     - ...

3. 서버 개발 측면에서의 생각

   - 지금 우리가 알고 있는 것?
     - 자바로 개발한다
   - 지금 우리가 모르고 있는 것?
     - 웹앱 만들건데, 프레임워크 뭐할까? -> 스프링부트로 하자 (알고 있는 것으로 됨)

4. 알고  있는 것 기반으로 코딩 진행

   

### 기타 

- 개발속도 높이자 ㅜㅜ 
- 주 언어 선택하자 ㅠㅠ
- 3~4주 정도 스프링 배움
- 바로 코딩 실습 할거예요~~ 

---

## [3] 19.03.22

### 준비

1. 접속가능한 mysql 데이터베이스 
2. 교재 - 토비 스프링

### Design Pattern

개발자들의 경험상 노하우들을 모아놓은 이론들

​	-> 실제 동작되도록 만든 것 : 프레임워크

1. Template Method Pattern

2. Factory Method Pattern

3. Strategy Pattern

4. Template / Callback Pattern

### DI (Dependency Injection) (= IoC)

### 해보기

#### 요구사항

이미 저장되어있는 사용자정보를 ID를 주면 이름과 패스워드를 가지고 오는 프로그램을 만들어줘.

(= 데이터 액세스하는 라이브러리를 만들어줘. -> 유저에 해당하는 DAO를 만들어줘.)

모르는것 : 뭘로 개발하지? -> 자바로 개발하자. (아는것)

#### 데이터베이스 정보

청길 - 172.18.102.128 portal portaljejunu

헐크 - 192.168.0.54 jeju jejupw

#### JDBC란?

자바에서는 데이터베이스를 위한 표준 인터페이스가 있다. 내가 mysql을 쓰고 싶다면, 그 인터페이스를 구현해야함. 

그 구현한 것을 드라이버라고 하며, mysql 사에서는 JDBC라는 드라이버를 제공하고 있다.

- ```java
  jdbc:mysql://192.168.0.54/jeju?serverTimezone=UTC
  ```

  jdbc:mysql 프로토콜을 사용함

커넥션 맺어짐 -> 소켓통신에 들어감. (tcp 하위에서 프로토콜이 돌아감)

#### 리팩토링

코드 작성 -> 초록불 나오게 만듬 -> 리팩토링 

extract method (메소드 추출) 작성하면 됨 

### 기타

- DB는 절대로 외부에 오픈되지 않음! 무조건 내부망에서만 액세스 가능하게 해야함. 

  - APP의 경우에는, 외부에 오픈되어야 함.
  - ==> App-외부 간 보안이 필요. (App-DB는 자유롭게 드나들어야하니까 ㅠ)
  - DB를 외부 클라우드 서버에 넣어야 할 경우, SSL 레이어가 거의 필수임 
  - 단, SSL 레이어 쓰면 속도가 엄청 느려져서 성능이 별로... -> DB가 내부망일 경우 안쓰는 것을 권장.

---

## [4] 19.03.29

### 요구사항

>> > > > > > 이미 저장되어있는 사용자 정보를 ID를 주면 이름과 패스워드를 가지고 오는 프로그램을 만들어줘.
>> > > > > >
>> > > > > > 한라대학교랑 제주대학교에서 쓸거야.
>> > > > >
>> > > > > #### 문제사항
>> > > > >
>> > > > > DB가 다르다. 다른 db와도 커넥션 해보자.
>> > > > >
>> > > > > ​	-> 어떤 DB 정보가 나올지 모르므로, **추상화**를 통해 해결
>> > > > >
>> > > > > ### 추상화
>> > > > >
>> > > > > *모르면 추상화!!*
>> > > > >
>> > > > > 1) DB connection 부분에 **abstract** 키워드 추가 -> 추상클래스 및 추상메소드화 시킴
>> > > > >
>> > > > > 2) (테스트코드) UserDao가 빨간줄이니까 어떻게 해볼까...
>> > > > >
>> > > > > ​	-> JejuUserDao, HallaUserDao로 세분화  
>> > > > >
>> > > > > 3) (UserDao 를 상속하는) JejuUserDao를 만들어보자! 
>> > > > >
>> > > > > ​	- 단점 : 새로운 접속방법이 생길때마다 Dao 새로 만들어야함
>> > > > >
>> > > > > 
>> > > > >
>> > > > > ### Template Method Pattern
>> > > > >
>> > > > > 상속 기반의 추상화를 기반으로 하는 패턴.
>> > > > >
>> > > > > 추상메소드를 갖고 있는 추상클래스를, 상속받아서, 오버라이딩으로 추상메소드를 구현
>> > > > >
>> > > > > 
>> > > > >
>> > > > > ### Factory Method Parttern

object를 return 하는데, 그 object를 결정하는 것이 상속 받은 애가 결정해줌.

ex) getConnection() 에서 connection을 UserDao가 아니라, 그것을 상속 받은 JejuUserDao가 결정함.

![img](https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/FactoryMethod.svg/300px-FactoryMethod.svg.png)



### 요구사항2

상품을 조회, 등록 했으면 좋겠어.

​	-> 새로운 도메인모델 생김.

​	-> getConnection 을 같이 쓰네? -> 추상화를 상속기반 추상화로는 할 수 없네?

​		==> (중복코드 빼서) 인터페이스를 만들자 (커넥션 메이커) 

*요구사항이 생겼으면 바로 **테스트케이스**를 작성하라!!*



### 리팩토링

UserDao들이 getConnection을 중복코드로 같이 씀 -> 델리게이트로 뽑자!

1) getConnection을 델리게이트(다른 클래스에 위임) 시켜서 하나의 클래스로 뽑음

​	-> ConnectionMaker 생성

​	*extract method : method 분리 (-> 내부클래스 재사용)*

​	*delegate : Class 분리. (-> 외부클래스 재사용)*

2) 커넥션 하는 부분을 추상화 시키자

 - Class 레벨에서 추상화를 시킬 것. -> interface! 

3) interface는 객체를 못 만드니까, 구현클래스를 만들어서 쓰자. 

4) new JejuConnectionMaker() 이 디펜던시를 없애고 싶어. 그래야 Halla도 쓰지.

​	-> 생성자로 Maker를 받자! (밖에서 누군가가 디펜던시를 갖고 있으나, 나는 없음.)



### Strategy Pattern

![img](https://upload.wikimedia.org/wikipedia/commons/3/39/Strategy_Pattern_in_UML.png)

뭐가 들어올 지 아는 부분 (변하지 않는 부분) : Context

모르는 부분 (계속 바뀔 부분) : Strategy

Strategy는 interface로 추상화해서 따로 구현하고,

​	Context 안에 Strategy를 유동적으로 넣었다 뺐다 함.



### 현재 문제점

UserDao는 현재 디펜던시가 없음. 그러나 클라이언트는 디펜더시를 갖고 있음.

클라이언트 입장에서는 계속 일일이 바꿔주어야 함. 

​	-> 또 남한테 디펜던시 던져보자!

==> 디펜던시를 전부 책임지고, 원하는 object instance만 돌려줄 클래스(Factory) 만듬. (Factory 패턴)

Factory : instance를 던져주는 역할.

**이 DaoFactory class 자체가 Spring이다.**



### Dependency Injection (DI) = IoC

![Dependency injectionì ëí ì´ë¯¸ì§ ê²ìê²°ê³¼](https://www.tutorialsteacher.com/Content/images/ioc/DI.png)

Service가 Client에 의존성 떠넘기고, Client는 Injector(Factory)에 떠넘김.

Injector의 의존성이 Service까지 이어짐.



### Java Build

자바 소스코드를 완전체로 만드는 것

옛날에는 그 과정을 shell script로 작성한 후 그 실행결과를 배포했음. 

#### 과정

1) Clean :: 옛 코드 등을 정리

2) Javac :: 컴파일

3) test :: 검증

4) packaging (jar, war, ear) 

​	<u>jar : 클래스들을 잘 압축해서 넣은 것</u>

​	war : 웹 어플리케이션을 잘 패키징해놓은것

​	ear : 관련된 여러 서비스들의 집합체

5) deploy :: 배포



### 빌드 자동화 솔루션

#### Ant

xml 기반. 가독성이 shell 보다 좋음. intelli j 에서 지원.

빌드할 수 있는 lib가 xml로 정의되어 있음.

**단점 : lib 의존성 관리가 너무너무 힘듬**

#### Maven

![mavenì ëí ì´ë¯¸ì§ ê²ìê²°ê³¼](http://wiki.netbeans.org/wiki/images/b/bd/Completion-value_MavenBestPractices.png)

![maven êµ¬ì¡°ì ëí ì´ë¯¸ì§ ê²ìê²°ê³¼](http://www.egovframe.go.kr/wiki/lib/exe/fetch.php?media=egovframework:dev:dep:build:mvn-dir.gif)

xml 기반.

Java 특화

라이브러리 저장소에 library들 저장하고, lib 간의 의존성을 정의해둠.

lib를 직접 복붙할 필요 없이, 어디서 무엇을 가져올 것인지 (= dependency) 명시해두면 알아서 lib를 가져옴.

정해진 규칙이 존재. 

​	<u>ex) 배포하지 않을 애들 구분 (컴파일, 테스트에만 필요한 애들)</u>

​		--> dependency 가 정의되어 있다. 

디렉토리 구조가 표준화 되어 있음.

deploy : lib 저장소에 자료파일을 올리는 것. (왜냐면, 다른 애들이 쓰고 싶다고 하면 해당 repo 정보만 알면 되니까!!)

컴파일때 쓸 툴 같은 정보들은 plugin으로 꽂아줘야함.

![maven life cycleì ëí ì´ë¯¸ì§ ê²ìê²°ê³¼](http://wiki.gurubee.net/download/attachments/2457635/6_MavenLifecycle.png)

maven의 lifecycle.

ex) clean을 한다면 pre-clean까지만, compile을 한다면 process-resources 까지 한다. 

**단점**

**1) 특정 버전 태그가 불가능**

**2) xml이라 코드기반이 안되고 무조건 plugin으로 만들어야 함 **

#### Gradle

Groovy 언어 기반. (코드 기반)

Java 외에도 여러 언어에서 사용 가능

확장가능하고 ant, maven 다 가능하고 ... 먼가 조아 

lifecycle 없음

maven 꺼를 plugin 으로 쓸 수 있음

![gradle êµ¬ì¡°ì ëí ì´ë¯¸ì§ ê²ìê²°ê³¼](http://www.egovframe.go.kr/wiki/lib/exe/fetch.php?w=700&media=egovframework:dev3.6:dep:build_tool:gradle:gradlefolder.png)



### 다음주 : 그래들 환경 만들기

1. 자바 프로젝트 -> 그래들로 변경
2. 그래들 환경에서 작업해보기 

---

## [5] 19.04.05

### 강의 목표

Spring으로 dependency 책임져주는 녀석을 관리하고 배포까지 해보자.

Spring : dependency를 모두 책임져 주는 녀석.



### Gradle

Gradle: task를 실행할 수 있는 플랫폼.

maven의 repository를 같이 씀 -> 그 기반 하에 같이 씀

plugin : 별도로 구현해 둔 녀석들. 만들 수 있음

해당 플러그인을 만들면, 플러그인 레파를 만들고, 나만의 플러그인 아이디가 있는데, 걔네를 인스톨한다 ? 

gradlew :: 서버인스톨 안해도 돼. 이 파일 하나만 던져줘. 그럼 얘가 알아서 실행해줘.

​	==> 서버 입장에서는 디펜던시가 없음. 이 파일만 있으면 그래들 쓸 수 있음.



### Bin

bin : 보통 하나의 object를 의미함.

Spring Container가 관리하는 Java Object. (UserDao)

getBean() -> instance를 얻음.

xml 혹은 object로 정의 가능 



xml이 관리하기는 더 편함. 왜나면 여러 xml을 만들어두고 걔만 특정폴더에 넣어서 하면 됨.

하지만, bean을 너무 많이 만들게되어서 복잡해지고 가독성 ㄴㄴ. 그래서 보통 소스(object)로 관리함.



### dependency lookup

instance를 lookup 하는 것?

Spring은 dependency lookup을 해주는 프레임웍이다.



### 만들어보자!

1. Gradle 프로젝트로 전환하고,
2. ApplicationContext를 활용하여, Dao Factory를 Spring으로 만들어보자!



### Lombok

Getter, Setter 등을 간단히 만들어주는 라이브러리.

**롬복을 쓰기 위해서는, preferences에서 Enable annotation processing 체킹 해주어야함.**

~~~java
@Getter
@Setter
public class User {
    private long id;
    private String name;
    private String password;
}

~~~

@Data 어노테이션도 있으나, 얘는 의미있는 해시코드를 같이 만들어줌.

-> 만약 depth가 있는 인스턴스 중 recycle 하는 경우가 있으면, 무한루프 돌아서 멈춰버림.



### Dependency 관리를 조금 더 딥하게 해보자!

#### ConnectionMaker 를 DataSource로 변경

value들에 대한 dependency를 없애보자.

1. getConnection() 내부의 DB 접속 정보들을 다 private 전역변수로 빼버리자.

2. 이 정보들은 매우 중요한 개인정보들이다. 

   1. 요즘은 이 정보들을 시스템 환경변수로 넣어버림. -> dependency는 서버에 있다. 보안 굳.

3. ~~~java
   
   // 시스템 환경변수 (System property)의 것을 가져와서 넣어버림.
   @Value("${db.className}");
   private String className;
   ~~~

4. 이제 환경변수를 연결해줘야겠지?

   1. 자바 실행 시 집어넣는 경우
   2. 프로젝트 세팅할 때 집어넣는 경우 (지금 우리)

5. 환경변수 세팅

   1. 규칙 

      | Name          | 읽는거        | Value                    |
      | ------------- | ------------- | ------------------------ |
      | 대문자_대문자 | 소문자.소문자 |                          |
      | DB_CLASSNAME  | db.classname  | com.mysql.cj.jdbc.Driver |

6. 위 까지의 과정을 DataSource로 해보자! 

7. 의존성을 몰아주기 위해, DaoFactory에 dataSource() Bean을 만들어준다.

#### DataSource

database 커넥션을 위한 여러가지 정보가 정의되어 있음.

**ClassNotFoundException**을 반드시 캐치 해주어야함!

​	단, 비지니스적으로 딱히 <u>상관이 없다면</u>, 예외를 받긴 했지만 전파하고 싶지 않다?

​		-> **RuntimeException**으로 바꾸어준다! (전파 안됨!)



### 가끔 서버가 죽어! 무슨 문제일까?

원인

1. **UserDao.java에서 계속 exception이 나! throw 해줘!  **
2. **-> (close 없이 반복) ==>**
3. ** close 안된게 쌓여서 터짐! **
4. 해결 => exception 발생하면 무조건 close! 



과연 끝일까?

-> resultSet과 preparedStatement가 null이 아니라면, 얘네도 자원해제! 



정말 끝?

SQL도 뭔갈 해줘야해...



#### UserDao extract method

1. 마지막 인덱스 가져오는 부분 뽑아다가 getLastInsertId() 메소드 만듬.
2. add()에 try catch 진행해줌 (get()과 동일하게!)
3. getLastInsertId()도 try catch 



### 요구사항

1.  사용자 삭제하기 만들어줘
2. 사용자 수정하기 만들어줘



### 구현

1. 요구사항이 나왔으니, tast case 만듬

   1. 수정
      1. 추가하고, <u>변경하고, 갖고 온 결과 확인</u>해야함.
   2. 삭제
      1. 추가하고, <u>삭제하고, 갖고 온 결과 없어야</u> 함.
      2. 삭제 테스트 할 때, get()에서 resultSet exception이 났네? 
         1. -> null 일 경우 넣어주자!

2. UserDao 소스가 너무 지저분해졌다...ㅠ => 다음시간에 계속...

   :: Hint ::

​	1) 다 똑같은데, 

​	2) 뭐가 올지 모르는 부분이 있어.

​		->   추상화. (클래스 단위 추상화)

## 중간고사

1. 강사님이 깃헙에 날코딩한 코드들 올려줌.
2. 로컬로 받아옴
3. 문제 요구에 따라 **리팩토링** 진행

---

## [6] 19.04.12

### 리팩토링

UserDao의 메소드들이 preparedStatement 쪽 빼고 죄다 동일하다.

preparedStatement 는 메소드마다 변하므로, interface 레벨로 추상화를 진행한다. **(Strategy Pattern)**

1. StatementStrategy interface를 만들고 
2. makePrepareStatement 메소드를 만들고
3. 각 method별로 특화된 구현클래스를 만든다 (ex: GetStatementStrategy)
4. 이 때, makePrepareStatement 메소드의 파라미터가 Object. 왜냐하면 ... 받는게 좀 다른가벼.



### 리팩토링2

굳이 makePrepareStatement 가 Object로 받아야만 할까?

StatementStrategy가 변하는 부분을 책임지게 하고, makePrepareStatement는 변치 않게(Context) 하면 안되나?

1. StatementStrategy가 생성자로 user, id 등 파라미터를 받게 함 

2. ```java
   StatementStrategy statementStrategy = new DeleteStatementStrategy(id);
   ```

3. 2를 try 구문에서 빼보면 

4. 3 빼고 죄다 동일함을 발견할 수 있음!!!

5. 그럼 Context니까, extract method로 빼자!!! (jdbcContextForUpdate method)

6. (요구사항) User DB 뿐만 아니라, 상품 DB도 jdbcContextForUpdate 를 쓴대!!! 

7. 여러 도메인에서도 쓸 수 있도록, Class 레벨로 추출하자!!

   1. Context애들을 delegate! (jdbcContext Class)

8. 의존성이 달라졌기 때문에, 오류가 남.

9. 의존성을 Userdao -> jdbcContext -> dataSource 로 변경! 





### Template CallBack Pattern

실행되는 메소드의 내용 자체를 파라미터로 넘겨줌 

**메소드 자체를 파라미터로 받는 패턴.**

보통은 method를 object로써 넘겨주지만, 자바에서는 메소드가 object로 취급되지 않기때문에, 

​	interface 혹은 람다를 통해서 구현함.



### 리팩토링3

StatementStrategy interface는 **메소드가 하나 뿐임.** 

1. 굳이 구현클래스를 만들지 말고, Template CallBack Pattern으로 구현.

2. 또 Context를 찾아볼까?
   1. 구현된 부분 중에서, 파라미터를 빼보자. (sql)
   2. prepareStatement 부분을 loop로 돌리고 싶은데?
   3. Object params[]에 set하는 애들 넣어놓고, loop문으로 만들어버리자.
   4. sql, parmas를 빼보자.
   5. 앗 나머지 부분 완전 같아!! => extract method 
3. 다른 도메인 (ex: 상품도메인)에서도 활용할 수 있도록 해보자.
4. => Jdbc Context에 넣어버리자!



### Jdbc Template

스프링에서 지원하는 Jdbc Context

#### add 구현하기

1. jdbc Template에는 insert가 없어서, update를 활용하여 직접 구현해야함.
2. jdbc Context랑 거의 비슷한데, KeyHolder라는걸 만들어서, return값을 걔로 받아옴

#### Get 구현하기

1. queryForObject 활용
2. ...

#### 우리에게 특화된 Jdbc Template 만들기

1. add를 우리에게 특화시켜서 insert 메소드 만들고

2. JdbcTemplate를 상속하는 JejuJdbcTemplate 만들어서 move
3. jdbcTemplate이 SQLInjection 캐치 다 함 



### 중간고사

1. 시험유형
   1. 사용자의 요구사항이 이겁니다. 뭘할까요. 리팩토링 하세요 ... 
   2. 지금까지 해 온 과정을 순서 하나씩 개발을 다 함
   3. Gradle 기반의 프로젝트를 헐크가 만들어서 git으로 공유를 해줄 것임
   4. 그 repo fork해서, 자기 환경을 만듬 (test case 돌아갈 수 있도록.)
      1. host, password, ... 를 세팅해놔야겠지?
   5. ...를 <u>4시까지 다 세팅</u>해두고, **4시부터 시험 시작!**
2. 유의사항
   1. 검색 불가
   2. 막히는 부분 있으면, 체크하고 그 부분에 한하여 오픈북으로 가능 (내 레포 보던가 동강 보던가...)
   3. 찾아도 모르겠으면 헐크가 가이드 해줌 
3. 제출 관련
   1. 한 과정이 끝날 때 마다, 헐크한테 컨펌을 받고
   2. tag 달아서 commit push 
   3. 최종 완료 모습은 지금 프로젝트.
4. 시험시간 2시간
5. DB는 로컬디비 쓰던가 실습때쓰는 지금 디비 쓰던가...



## [6-2] 19.04.18 중간고사 대비

### 체크리스트

$ git push origin --tag

[단축키]

파일 생성 :: Ctrl Alt Insert

지역변수 생성 :: Ctrl Alt V

멤버변수 생성 :: Ctrl Alt F

#### 문제 1)

1. Insert Query
2. preparedStatement.executeUpdate();
3. SELECT last_insert_id()

#### 문제 5)

1. Application Context
2. @Bean, @Configration

#### 문제 6)

1. Datasource
   1. **Connection pool의 Connection 관리 객체**
   2. 얘를 통해서 필요한 Connection을 획득/반납한다.
   3. 이용절차
      1. JNDI Server에서 lookup( ) 메소드를 통해 DataSource 객체를 획득한다.
      2. DataSource 객체의 getConnection( ) 메소드를 통해서 Connection Pool에서 Free 상태의 Connection 객체를 획득한다.
      3. Connection 객체를 통한 DBMS 작업을 수행한다.
      4. 모든 작업이 끝나면 DataSource 객체를 통해서 Connection Pool에 Connection을 반납한다.

2. Connection pool

   1. Connection 객체를 프로그램이 실행될 때 마다 생성하는 것이 아닌, 

      웹 어플리케이션이 서비스 되기 전에 

      웹서버에서 미리 생성하여 준비한 다음,

      필요할 때 준비된 Connection을 가져가 사용하는 개념.

3. 환경변수 명명규칙

4. @Value("${변수명}")

#### 문제 7)

1. try catch 단축키 :: Ctrl Alt T

#### 문제 8)

1. UPDATE userinfo SET name=?, password=? WHERE id=?;
2. nullValue()

#### 문제 10)

1. 람다식

   XXX xxx = param -> { };

#### 문제 13)

1. JdbcTemplate
   1. update, delete는 update() 사용
   2. add는 update(), KeyHolder 활용
   3. get은 ...



---

## [7] 19.04.26

### 블록체인



---

## [8] 19.05.03

### 기말 프로젝트

- 주제 : 자유주제
  - 6월 첫째주에 주제에 대한 이야기를 할거임.
  - 미리 주제 잡아두기. (실현 가능해야함)
- 스펙
  - 서버 사이드 : Spring -> API
  - 프론트 사이드 : 상관X. 웹이 편할걸?
- 기획서 함 봐줄거임
- 최종 발표
  - 완성도, 어디까지 완성 했는지, ... 
  - 발표할때 ... 누가 보러오는데 ... 인턴 각임... 
    - 서비스 마인드 1명 / 기술 1명 각인데

## Spring과 Web

1. ApplicationContext

   1. 개념

      1. 인스턴스를 new 하고, 관리해주고, 필요한 곳에 의존성을 주입해서 넘겨줌
      2. 스프링의 core.
      3. 전체 Application의 변하지 않는 것(Context)들을 모아둔 느낌.

   2. 종류

      1. extends BeanFactory
      2. StaticApplicationContext
         1. 실무에선 잘 쓰이지 않음.
         2. test 등록할 때 주로 사용.
            1. 테스트 할 때 마다 빈 등록하면 너무 느리니까, 내가 필요한 빈만 등록해서 테스트 하고 싶을 때 많이 씀.
      3. GenericXmlApppicationContext / ClassPathXml...
         1. xml에 bean 정의
      4. GenericGrooby...
         1. grooby에 bean 정의
         2. 코드 베이스로 정의하고 싶은 사람들이 주로 씀
      5. **AnnotationConfig...**
         1. annotation으로 bean 정의
         2. 주로 이거 씀
      6. Web...
         1. 웹 환경이 다른 애들이랑 좀 달라서, 먼가 좀 다름.
         2. StaticWeb... / XmlWeb...

   3. 계층 구조

      1. Parent를 정의 가능하며, ...(?)
      2. WebApplication에서 주로 사용
      3. ![ApplicationContext ê³ì¸µêµ¬ì¡°ì ëí ì´ë¯¸ì§ ê²ìê²°ê³¼](https://t1.daumcdn.net/cfile/tistory/250D054A522D2AC410)

   4. Bean 등록

      1. 방법
         1. xml 등록
         2. annotation 등록 (@Configuration, @Bean ... )
         3. object 자체에 어노테이션 등록 (@Componet, @Controller, @Service, @Repository ... )
            1. 레이어드 아키텍쳐 기반
               1. 각각의 레이어의 독립성을 위하여 나눔
               2. 순수한 객체지향의 느낌은 아님. 객체를 단지 데이터 전달용으로 사용함.
                  1. 순수 객체지향의 객체 : 그 객체가 할 수 있는 메소드들도 막 갖고있음.
                  2. --> DDD (도메인 주도 설계) : 순수 객체지향 지향

   5. DI 설정

      1. 방법
         1. Setter혹은 property를 통해 직접 주입 (Setter Injection, Property Injection) 
            1. <property>...</property>
         2. 생성자를 통해 주입 (Constructor Injection)
            1. <constructor-arg> ... </constructor-arg>
         3. Annotation  기반 주입 
            1. @Resource(name="jdbcTemplate")
            2. @Autowired

   6. Value 설정

      1. 방법

         1. <property name = "name" value "value"> ... </property>

         2. @Value 어노테이션

            1. ~~~java
               @Value("sohee")
               private String name;
               ~~~

   7. Bean Scope

      1. Bean이 갖고 있는 프로퍼티들은 다 주입 가능.
      2. 종류
         1. **singleton (Default)**
            1. New를 한 번만 해줌. 인스턴스가 하나 뿐.
            2. 인스턴스가 하나일 때 문제점
               1. 오브젝트가 가변형일때. (ex: User 오브젝트는 사용자 수 만큼 가변한다.)  -- Model
               2. ==> Spring Bean으로 활용하지 않음. (Bean에는 메소드 중심의 애들만 넣음!)
               3. 그래도 굳이 Bean으로 쓰고 싶다면? ==> 밑에 제시된 다른 Bean Scope를 활용하라.
                  1. (그러나 스프링 정신에 위배됨)
         2. prototype
            1. Bean을 가져올 때 마다, 새로운 인스턴스를 던져준다.
         3. request
            1. 웹에서 사용
            2. request object 안에서만 새로운 bean을 준다.
         4. session
            1. 세션과 쿠키
               1. 세션 
                  1. 하나의 사용자가 브라우저나 앱을 통해서 활동할 때, 행동이 끝날때 까지의 과정에서, 로그인 정보 등의 정보를 유지해주기 위해서 생김. (활동을 기억해줌)
                  2. 정보 저장 위치 : 서버
               2. 쿠키
                  1. 클라이언트에게 특정 정보를 저장시키기 위해 생김.
                  2. 각 브라우저마다 쿠키 정보를 저장해놓고, 서버 요청 시, 쿠키 정보를 같이 전달해줌.
                  3. 정보 저장 위치 : 클라이언트
                  4. object 자체를 클라이언트에 저장함.
            2. 싱글톤으로 동작하다가, 세션이 바뀌면 새로운 인스턴스를 만든다.
         5. application
            1. 특정 어플리케이션 기반 하에서는 싱글톤, 다른 어플에서는 새로운 인스.
         6. websocket
            1. 정의
               1. 한 번 서버랑 커넥션을 해 두면, 클라이언트가 끊으려고 해도 끊지 않음.
                  1. -> 서버 push가 가능
               2. 원래는 (http 통신 상에서는) request가 있어야만 서버가 response 가능.
               3. 그러나 websocket 에서는, 그냥 서버가 response 가능 (양방향 통신)
                  1. ==> ex) 채팅 등에 필요
            2. 웹소켓 안에서는 싱글톤

### Java Web Application

1. War로 패키징 됨
2. 구조
   1. ![java web app êµ¬ì¡°ì ëí ì´ë¯¸ì§ ê²ìê²°ê³¼](https://www.stechstar.com/user/zbxe/files/attach/images/3754/350/053/cd412bc627d3b15c87e0e76ae4f70443.png)
   2. WEB-INF :: 완전 보안킹임; 히든임;
3. **Servlet** 
4. **JSP**
   1. 얘가 servlet을 만들어주고, ................... ==> java web app 은 servlet으로 동작된당

## Servlet 

java web application의 기본

1. 싱글톤

2. 기능
   1. init()
   2. service()
   3. destroy()

3. 생명주기 

   1. init -> service (또 호출시 -> service) -> destroy

4. 

   ~~~~java
   res.getWriter().println("<h1> this is html tag </h1>");
   ~~~~

   ​	이렇게 html을 하드코딩함. (==> 그거 없애려고 나온게 JSP)

   

## Filter

1. 서블릿의 service를 통해서 리퀘스트를 수행하는데, 
2. 이 리퀘스트를 수행(=서비스 실행)하기 전 후에, (모든 서블릿에) Filter를 걸어줌
   1. ex) 수행 후에 log 찍기
   2. ex) charset 설정 
   3. ex) 로그인 사용자만 가능한 서비스에다가, 로그인 검사 넣어주기

## Listener

1. 이벤트드리블. 이벤트 발생 시 받아줌.



## 실습

### 순수 자바 웹 어플리케이션을 구현해보자!

1. 환경설정

   1. 톰캣 설치
   2. Web 프로젝트 생성
      1. <https://whitepaek.tistory.com/13>

2. 서블릿 활용

   1. 그래들 디펜던시 추가

      1. ```java
         implementation 'javax.servlet:javax.servlet-api:4.0.1'
         ```

   2. GenericServlet 상속 Servlet 생성

      1. init, service, destroy
      2. 참고
         1. log.info
         2. @Slf4j

   3. webapp\WEB-INF\web.xml 생성

      1. ![1556875226857](C:\Users\sohi8\AppData\Roaming\Typora\typora-user-images\1556875226857.png)

3. exploded : run 마다 해당되는 compile 되는 애들만 동적으로 바꿔서 war 파일 만들어서 실행시켜줌 헤헤 



---

## [9] 19.05.10

### 기말고사 관련

#### 스케줄

1. 기획서 

   - ~ 5/24

   - 각자 5분 정도 기획서 발표.
   - 화면 설계서를 작성하고, 화면에 대한 설명을 작성할 것. (하영드리미 참고)
   - 아이디어 없으면 하영드리미에 있는 기획서로 개발해도 됨.

2. 프로젝트 진행

   - 5/24 ~
   - Git repo 써야 하고, 수시로 commit 해라. 
   - Spring boot 기반의 MVC와 JPA를 활용할 것.
   - (Option) Client는 자유 선택
   - 애자일 방식으로, 간단한 동작 부터 만드는 것을 추천.

3. 평가

   - 상대평가
     - 중간고사 20점 (min -3)
     - 수업참여도 20점 (min -10)
     - 출석 10점 (min -2)
     - 기말 프로젝트 난이도 및 창의성 10점 (기획서 측면)
     - 프로젝트 결과 40점
     - B0 2명, B+ 3명, A0 2명, A+ 3명 (약간의 변동은 가능)
   - 최종 발표에서 동작하는 결과만 본다. 

4. 기타

   - 기말고사 전 2주는 수업 없음.
   - 대신 프로젝트 진행 중 이슈 해결 도와줄 것임.

### Java Web Application

Spring boot : Web Application 서버 (Tomcat)이 내장되어 있음 

보통은 WAS를 두고, 거기에 war를 deploy해서 씀



### Filter

request가 들어올때, 앞에서 먼저 걸러주고, (전처리)

reponse가 나가기 전에, 뒤에서 한번 걸러주고, (후처리)

---> 공통 로직을 리팩토링 하기 좋은 솔루션



1. 생명주기	
   1. init() 
      1. 서버 킬 떄. 
   2. doFilter()
      1. 서블릿 동작 전후
   3. destroy()
      1. 서버 죽을 때.

2. 코드

   1. HelloFilter.java

      ~~~java
      import lombok.extern.slf4j.Slf4j;
      
      import javax.servlet.*;
      import java.io.IOException;
      
      @Slf4j
      public class HelloFilter implements Filter {
          @Override
          public void init(FilterConfig filterConfig) throws ServletException {
              log.info("===================filter init");
          }
      
          @Override
          public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
              log.info("===================filter pre"); // 앞에서 걸러주기
              chain.doFilter(request, response); // 서블릿 동작
              log.info("===================filter post"); // (서블릿 동작 끝난 후에) 뒤에서 걸러주기
          }
      
          @Override
          public void destroy() {
              log.info("===================filter destroy");
          }
      }
      ~~~

      

   2. web.xml

      ~~~xml
          <filter> # 필터 만들어주고
              <filter-name>hellofilter</filter-name>
              <filter-class>kr.ac.jejunu.servlet.HelloFilter</filter-class>
          </filter>
          <filter-mapping> # 필터 매핑시켜줌
              <filter-name>hellofilter</filter-name>
              <url-pattern>/hello</url-pattern> # 이 url로 들어오면 이 필터 쓴다고.
          </filter-mapping>
      ~~~

![001](.\pics\001.png)

### Listener

1. 코드

   1. HelloContextListener.java

      ~~~java
      @Slf4j
      public class HelloContextListener implements ServletContextListener {
          // 듣고 있다가 context가 초기화 될때
          @Override
          public void contextInitialized(ServletContextEvent sce) {
              log.info("*********context init");
          }
      
          // context가 destory 될때
          // tomcat 서버는 안뜸; 아마 context destroy 전에 server destroy 하는듯.
          @Override
          public void contextDestroyed(ServletContextEvent sce) {
              log.info("*********context destroy");
          }
      }
      ~~~

      

   2. web.xml

      ```xml
      <listener>
          <listener-class>kr.ac.jejunu.servlet.HelloContextListener</listener-class>
      </listener>
      ```

2. 필요
   1. context 로딩, 이벤트, 모니터링 솔루션 등...
   2. 서버 상태가 어떤 상태지 알아야 할때 -> 리스너 이벤트를 통해서 암

![002](.\pics\002.png)



### Annotation

요즘은 web.xml을 제거하고, annotation으로 관리할 수 있다.

-> WEB-INF 디렉토리 지워짐, 코드가 직관적임.

-> xml 가독성 구려서 요즘은 annotation을 선호하는 추세.



~~~java
@WebServlet(urlPatterns = "/hello")
@Slf4j
public class HelloServlet extends GenericServlet {

@WebFilter(urlPatterns = "/hello")
@Slf4j
public class HelloFilter implements Filter {

@WebListener
@Slf4j
public class HelloContextListener implements ServletContextListener {
~~~



이케하면 web.xml이 없어도 설정이 됨

(지금은 오류가 나는데, 아마 톰캣에 web.xml이 배포가 되어서 그런걸까...?)



### SpringFramework

![spring framework êµ¬ì¡°ì ëí ì´ë¯¸ì§ ê²ìê²°ê³¼](https://blog.outsider.ne.kr/attach/1/1053440826.gif)



우리가 다룰거 : ORM, Web MVC



### Web 아키텍쳐

#### MODEL 1

![model1 jspì ëí ì´ë¯¸ì§ ê²ìê²°ê³¼](https://images.techhive.com/images/idge/imported/article/jvw/1999/12/model1_sml-100158071-orig.gif)

비즈니스 로직과 화면을 분리하자.

JSP : 화면 담당 (html 코드 그대로를 파일로 저장함~)

Java Bean : 비즈니스 로직 담당



비즈니스 로직이 복잡해지면서, JSP에 담기게 됨? -> 둘이 분간이 안감

==> MODEL 2



#### MODEL 2

![model2 jspì ëí ì´ë¯¸ì§ ê²ìê²°ê³¼](https://images.techhive.com/images/idge/imported/article/jvw/1999/12/model2_sml-100158072-orig.gif)

Model-View-Controller 3가지로 빼보자!

JSP만 있을 때의 골치 : request, response를 처리하는 로직을 넣는게 복잡했었음.

​	--> Controller에 빼자!



- Controller : request, response에 대한 코드 처리 수행

- View : Html과 똑같이 생긴 녀석

- Model : 비즈니스 로직만 수행



#### Spring MVC

![spring mvc dispatcherservletì ëí ì´ë¯¸ì§ ê²ìê²°ê³¼](https://docs.spring.io/spring/docs/current/spring-framework-reference/images/mvc-context-hierarchy.png)



#### Spring MVC Life Cycle

![spring mvc life cycle view controllerì ëí ì´ë¯¸ì§ ê²ìê²°ê³¼](http://i.imgur.com/PPnvoNS.png)

Handler Mapping : 어떤 클래스를 찾아서 실행해야 할지 찾아줌. (Dispatcher Servlet이 함)

​	-> Handler Adapter (Controller) : 매핑된 클래스에서, 어떤 메소드를 수행해야할지 알려줌.

View Resolver : 잘 정의된 데이터들을 해당되는 뷰에 잘 담아줌 (뷰 ex: JSP, json)



#### Handler Mapping & Handler Adapter

~~~java
// 스프링에서는 bean 이름을 path로 지정함.
// 이 bean 이름을 가지고 mapping을 진행함. (by Handler Mapping)
// (Handler Mapping의 종류?는 servlet 정의한 xml에서 정의) -
/// default : BeanNameUrlHandlerMapping, RequestMethodHandlerMappgng
// ViewResolver가 bean이름.jsp 이라는 view에 연결시켜줌
@org.springframework.stereotype.Controller("/helloworld")
public class SimpleController implements Controller { // 이 컨트롤러 자체가 하나의 Adapter.
    // Handler Adapter에서 handleRequest method 수행
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView(); // 연결할 view 기본 : bean이름.jsp
        modelAndView.addObject("hello", "hi sohi!");
        return modelAndView;
    }
}

BeanName핸들러매핑 -> SimpleController 핸들러어댑터 -> ViewResolver

~~~



##### Handler Mapping

어떤 클래스를 찾아서 실행할지 결정.

1. 종류
   1. BeanNameUrlHandlerMapping (Default)
   2. RequestMethodHandlerMapping  (Default, 어노테이션 기반)
   3. 

##### Handler Adapter

어떤 메소드를 수행할지 결정.

1. 종류

   1. Simple

      ModelAndView : Spring의 기본 Object. 

      ​	어떤 모델과 어떤 뷰를 담을지 결정.

   2. HttpRequest

      ~~~java
      @Controller("/request")
      public class HttpRequestController implements HttpRequestHandler {
          // Simple과 달리, return이 void다. 
          @Override
          public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              response.getWriter().println("<h1>hi</h1>"); // servlet처럼, html 하드코딩 해줘야함.
              // view가 없는 servlet에서 사용
          }
      }
      
      BeanName핸들러매핑 -> HttpRequest 핸들러어댑터
      ~~~

   3. SimpleServlet

      ~~~java
      //@WebServlet(urlPatterns = "/hello")
      // 서블릿을 그대로 마이그레이션 하기 위해서.
      // 이 어댑터를 꽂으면, 다른 어댑터가 동작을 안 함; (디폴트는 하나봄)
      @Controller("/servlet")
      @Slf4j
      public class HelloServlet extends GenericServlet {
          @Override
          public void init() throws ServletException {
              log.info("*********** servlet init *************");
              super.init();
          }
      
          @Override
          public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
              log.info("*********** servlet service *************");
              res.getWriter().println("<h1> this is html tag </h1>");
          }
      
          @Override
          public void destroy() {
              log.info("*********** servlet destroy *************");
              super.destroy();
          }
      }
      ~~~

      



**주로 RequestMethod핸들러매핑-RequestMethod핸들러어댑터 조합을 많이 씀**

~~~java
@Controller
@RequestMapping("/annotation") // 클래스나 메소드에 다 넣을 수 있음. class에 있다면, /annotation 하이라키 구조가 나오겠지?
public class AnnotationController {
    
    // @RequestMapping 을 받은 애가 핸들러가 됨.
    @RequestMapping("/hello") // url : /annotation/hello
    public String hello() { // return이 String : view name을 직접 지정해주겠다는 뜻
        return "helloworld";  // view name = helloworld
        // InternalResourceViewReslover -> helloworld.jsp 찾아감 -> 띄움
    }


    @RequestMapping("/hello2") // url : /annotation/hello2
    public ModelAndView hello2() {
        ModelAndView modelAndView = new ModelAndView("helloworld"); // view mapping
        modelAndView.addObject("hello", "annotation hi");
        return modelAndView; // InternalResourceViewReslover -> helloworld.jsp 찾아감 -> 띄움
    }
}

~~~



#### View Resolver

어떤 종류의 View를 연결할지 결정

1. 종류
   1. InternalResourceViewResolver

#### View

1. 종류
   1. InternalResourceView
   2. JspView



#### Servlet 우선순위?

Servlet을 2개로 설정해둠

1. HelloServlet.java

   ~~~java
   @WebServlet(urlPatterns = "/hello")
   @Slf4j
   public class HelloServlet extends GenericServlet {
   ~~~

   

2. web.xml

   ~~~xml
       <servlet-mapping>
           <servlet-name>dispatcher</servlet-name>
           <url-pattern>/</url-pattern>
       </servlet-mapping>
   ~~~

root Servlet : dispatcher

(Spring이 아닌) JWA 에서 처음 서버 킬 때, root가 아닌 애부터 탐색한다캄.

그래서 hello servlet이 먼저 탐색 되나봄.

그래서 /hello에서는 hello servlet이, 그 외의 url 에서는 dispatcher (root)가 실행됨.

(그리고 hello servlet은 어노테이션으로 url을 지정해줘서, 좀 더 명시적이라 우선순위 더 높다?)

---

## [10] 19.05.17

### Content Negotaiating View Reslover

request(url.js) -> response (json)

특정 미디어 타입에 따라, 결과를 다르게 뱉어주려고 설계된 방식

어떤 view랑 매핑을 해줄까? 하고 협상함

- mediaTypes 
  - .js 확장자면 -> application/json으로 보여줄게
  - .xml 확장자면 -> application/xml으로 보여줄게
- defaultViews
  - json을 보여줄때 사용할 view 설정
  - xml을 보여줄 때 사용할 view 설정
- viewReslovers
  - defaultViews가 아닌 애들을 보여줄 view 설정
  - **Internal Result View Reslover**를 탐 



### EtcReslover

1. HandlerExceptionReslover
   1. View를 해석해주는 애는 아님. (= View Reslover가 아니다.)
   2. Exception이 떨어짐 (ex : 500 error! ) -> exception 떨어진걸 캐치 -> 특정 view로 보내줌 (ex: 에러 안내 화면)
2. MultipartReslover
   1. View를 해석해주는 애는 아님. (= View Reslover가 아니다.)
   2. Multipart request 
      1. 모든 request는 string. (ex: query, body)
      2. 그러나 파일은 byte임. 
   3. 요청 자체를 처리하는 느낌?
   4. 파일 업로드시 byte를 -> file로 변경해주는 역할을 함.



### Build 패턴

@Builder : Obejct를 생성하기 위한 기본 패턴. (lombok)

Object 자체를 쉽게 만들어주기 위한 하나의 패턴.

// 생성 대상이 @Builder라면, 이렇게 쉽게 생성해줄 수 있음

~~~java
User user = User.builder().id(1).name("hulk").password("1234").build();
~~~



### Exception

Runtime Exception은 다른 exception과 달리, throw를 안 받아도 됨. 그래서 자주 씀 ㅇ.< 



### ExceptionHandler

~~~java
@Controller
@RequestMapping("/user")
public class UserController {
   ...

    @RequestMapping("/error")
    public void error() {
        throw new RuntimeException("runtime exception");
    }

    @ExceptionHandler(Exception.class) // 어떤 Exception이 떨어졌을때 인지도 설정할 수 있음
    public ModelAndView errorPage(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("e", e);
        return modelAndView;
    }
}

~~~



dispatcher 서블릿 찾고 -> handler exception revloser누군지 찾아준 후 -> 핸들러어댑터 실행 하다가 -> 에러 나면 -> handler excption reslover에 의하여 -> 누가 익셉션핸들러인지 찾고 -> 걔한테 던져줌

