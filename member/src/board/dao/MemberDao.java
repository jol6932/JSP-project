package board.dao;

import java.sql.*;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import board.member.Member;

public class MemberDao {
	private Connection con = null;
	private PreparedStatement psmt;
	ResultSet rs = null;
	
	
	public MemberDao(){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jspuserc","jsp1234");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	public int insertMember(Member member){
		Member m = new Member();

		m=member;
		String sql = "insert into mem values(?,?,?,?,?,?,default)";
		psmt = null;
		System.out.println(m.getGender());
		

		
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, m.getId());
			psmt.setString(2, m.getPwd());
			psmt.setString(3, m.getName());
			psmt.setInt(4, m.getAge());
			psmt.setString(5, m.getGender());
			psmt.setString(6, m.getAddr());
			
			int result = psmt.executeUpdate();
			
			if(result == 1)
				return result;
			psmt.close();
			con.close();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
		
	}
	
	public int LoginMember(String gid,String gpwd){
		
		
		String id = gid;
		String pwd = gpwd;
		
		String sql = "select * from mem where id=?";
		
		try {
			psmt=con.prepareStatement(sql);
			
			psmt.setString(1, id);
			
			rs=psmt.executeQuery();
			
			if(rs.next()){
				String pwdox = rs.getString("password");
				if(pwd.equals(pwdox)){
					return 1;//로그인 성공
				}
				else
					return 3;//패스워드 오류
			}
			psmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;//존재하지 않는 아이디
		
		
	}

}
