package m1jdbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/* JDBC : Java DataBase Connectivity
 * 
 * JDBC 5 Step
 * 1 - Driver loading (mysql-connector-j-8.4.0.jar)
 *     - Driver : DBMS 제조사가 제공하는 클라이언트 모듈.
 * 2 - 연결 확립 : Connection
 * 3 - 질의 생성 및 전송 : Statement & Query
 * 4 - 결과 확인 : CUD - CUD 건수 리턴, R - ResultSet 리턴.
 * 5 - 연결 해제 : Connection Close
 */
public class JDBC3CreateTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Step1.
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step2.
        String url = "jdbc:mysql://127.0.0.1:3306/ureca";
        String user = "root";
        String password = "mysql";
		Connection con = DriverManager.getConnection(url, user, password);

		// Step3.
		Statement stmt = con.createStatement();

		// Step4.
		String query = "CREATE TABLE test_board("
				+ "brd_no INT PRIMARY KEY AUTO_INCREMENT"
				+ ", brd_title VARCHAR(150) NOT NULL"
				+ ", brd_writer VARCHAR(60)"
				+ ", brd_cntns VARCHAR(3000) NOT NULL"
				+ ", brd_date DATETIME NOT NULL"
				+ ")";
		int successCount = stmt.executeUpdate(query);
		System.out.println(successCount + "건이 입력 되었습니다.");

		// Step5.
		stmt.close();
		con.close();
	} // main

} // class
