package exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import exam.dto.Member;

public class MemberDao {
	
	//생성자
	public MemberDao(){//웹에서 사용할수 없음-request,response를 사용할 수 없음.
		System.out.println("생성자");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //JSP는 예외처리 안해도 자동으로 해주지만 서블릿은 수동으로 해줘야함
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	    Connection con = null;
	    try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jspuserc","jsp1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//회원가입
	public void insertMember(Member member){
		System.out.println("회원추가");
		String sql = "insert into member values(id,pwd,name,?,?,?,default)";//사용자가 입력할 값을 일일히 입력하지 않고 ?표시로 대체입력
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    
	    pstmt.setString(1, id);
	    
	    pstmt.setString(2, pwd);
	    pstmt.setString(3, name);
	    pstmt.setInt(4, Integer.parseInt(age));
	    pstmt.setString(5, gender);
	    pstmt.setString(6, adr);
	}
	//회원삭제
	public void deleteMember(){
		System.out.println("회원삭제");
	}
}
