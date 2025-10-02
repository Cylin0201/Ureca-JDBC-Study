package m1jdbc.jdbc;

import java.sql.*;
import java.util.Scanner;

public class JDBC2Prepared {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        String inData = scan.nextLine();
        scan.close();

        Class.forName("com.mysql.cj.jdbc.Driver");

        // DriverManager: 드라이버의 중복을 막음. 한 종류의 드라이버는 하나의 메모리에 로딩되도록 관리.
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ureca",
                "root",
                "mysql"
        );

        //쿼리 중간에는 띄어쓰기 넣어주기.
//        String query = "SELECT e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, d.deptno, d.dname, d.loc " +
//                " FROM emp e, dept d" +
//                " WHERE e.deptno = d.deptno AND e.ename = '" + inData + "'" +  //inData는 작은 따옴표 처리 해야함.
//                " AND job = '" + 변수 + "'";
//        Statement stmt = conn.createStatement();


        //PreparedStatement 사용.
        //쿼리에 입력 값이 들어갈 때, PreparedStatement가 더 편리하다.
        String query = "SELECT e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, d.deptno, d.dname, d.loc " +
                " FROM emp e, dept d" +
                " WHERE e.deptno = d.deptno AND e.ename = ?";

        PreparedStatement psmt = conn.prepareStatement(query);
        psmt.setString(1, inData);

        ResultSet rs = psmt.executeQuery();
        //커넥션이 끊기면 rs는 조회할 수 없다.

        while (rs.next()){
            System.out.print(rs.getInt("empno") + "\t");
            System.out.print(rs.getString("ename") + "\t");
            System.out.print(rs.getString("job") + "\t");
            System.out.print(rs.getString("mgr") + "\t");
            System.out.print(rs.getDate("hiredate") + "\t");
            System.out.print(rs.getInt("sal") + "\t");
            System.out.print(rs.getInt("deptno") + "\t");
            System.out.print(rs.getString("dname") + "\t");
            System.out.println(rs.getString("loc"));
        }
        rs.close();
        psmt.close();
        conn.close();

        System.out.println();
    }
}
