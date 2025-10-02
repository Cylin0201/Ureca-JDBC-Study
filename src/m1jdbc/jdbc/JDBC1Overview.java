package m1jdbc.jdbc;

/*
* JDBC : Java Database Connect
* 5 Step.
* - 1: Driver loading (mysql-connector-j-8.x.x.jar)
*       Driver: DBMS의 제조사가 제공하는 DBMS와의 상호작용(접속, 트랜잭션)을 위한 클라이언트 모듈
* - 2: Connection (id, pwd, ip_dbms, port_dbms)
* - 3: 질의 생성 및 DBMS로 전송: Statement(Query를 담는 객체)
* - 4: 결과 확인: CUD - 성공 건수 / R - ResultSet이라는 객체가 온다.
*      ResultSet: 조회 결과를 담은 테이블 모양의 객체
* - 5: Connection close
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC1Overview {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/thisisjava",
                "java",
                "mysql"
        );

    }

}
