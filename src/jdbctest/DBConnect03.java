package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect03 {
	
	public static void main(String[] args) throws ClassNotFoundException  {
		// TODO Auto-generated method stub
		try
		{
			String url = "jdbc:mysql://localhost/world?characterEncoding=UTF-8&serverTimezone=UTC";
			String user = "root";
			String passwd = "hyerin453";
			Connection con = null;
			String sql = "insert into oneline(memo) values(?)";
			PreparedStatement pstmt = null;

			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, passwd);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "안녕하세요");
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			System.out.println("DB조회 성공");
		
		}
		catch (SQLException e)
		{
			System.out.println("DB연결 실패");
			System.out.print("사유 : " + e.getMessage());
		}
		
	}
}