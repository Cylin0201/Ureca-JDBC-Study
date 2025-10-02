package m1jdbc.jdbc;

import java.sql.*;
import java.util.Scanner;

public class JDBC4InsertPrepared {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Step1.
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step2.
		String url = "jdbc:mysql://127.0.0.1:3306/ureca";
		String user = "root";
		String password = "mysql";
		Connection con = DriverManager.getConnection(url, user, password);

		//data in
		Scanner scan = new Scanner(System.in);
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("작성자 : ");
		String writer = scan.nextLine();
		System.out.print("내용 : ");
		String contents = scan.nextLine();

		// Step3.
		String query = "insert into test_board(brd_title, brd_writer, brd_cntns, brd_date)"
		+ " values( ?, ?, ?, now() )";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, title);
        pstmt.setString(2, writer);
        pstmt.setString(3, contents);

		// Step4.
		int successCount = 0;
		successCount = pstmt.executeUpdate();
		System.out.println(successCount + "건이 입력 되었습니다.");

		// Step5.
		pstmt.close();
		con.close();

		scan.close();
	} // main

} // class
