package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBConnect02 {

	public static void main(String[] args) throws ClassNotFoundException  {
		// TODO Auto-generated method stub
		try
		{
			String url = "jdbc:mysql://localhost/?characterEncoding=UTF-8&serverTimezone=UTC";
			String user = "root";
			String passwd = "hyerin453";
			Connection con = null;
			String sql = "select * from oneline";
			PreparedStatement pstmt = null;
			PreparedStatement pstmt2 = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, passwd);
			
			pstmt2 = con.prepareStatement("use world");
			pstmt2.executeUpdate();
			pstmt2.close();
			
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(); //select문 실행할 떄
			//pstmt.executeUpdate(); 기타다른 문장 실행할 때
			while(rs.next()) {
				int no = rs.getInt(1);
				String memo = rs.getString(2);
				String wdate = rs.getString(3);
				
				System.out.println(no + ": "+ memo + ": ("+wdate+")");
			}
			rs.close();
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
