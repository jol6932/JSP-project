package board.dao;

import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import board.member.Member;

public class MemberDao {
	private Connection con = null;
	private PreparedStatement psmt;
	private Statement stmt=null;
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
	
	public List<Member> viewMembers(int snum,int lastnum){
		List<Member> list = new ArrayList<Member>();
		int startnum = snum;
		int endnum = lastnum;
		String sql = "select rownum as rnum,X.id,X.password,X.name,X.addr,X.gender,X.age,X.mregdate from (select rownum as rnum,A.id,A.name,A.addr,A.age,A.mregdate,A.gender,A.password from (select * from mem order by mregdate)A where rownum <=?)X where X.rnum>=?";
		

		System.out.println(startnum+","+endnum);
		try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, endnum);
			psmt.setInt(2, startnum);
			rs = psmt.executeQuery();
			
			
			
			while(rs.next()){
				Member member = new Member();
				member.setAddr(rs.getString("addr"));
				member.setAge(rs.getInt("age"));
				member.setGender(rs.getString("gender"));
				member.setId(rs.getString("id"));
				member.setMregdate(rs.getString("mregdate"));
				member.setName(rs.getString("name"));
				member.setPwd(rs.getString("password"));
				
				list.add(member);
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int DeleteMember(String id){
		String selectid = id;
		String sql = "delete from mem where id=?";
		int result=0;
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, selectid);
			result = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int Paging(){
		String sql = "select count(*) from mem";
		int result = 0;
		try {
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next())
				result = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
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
			/*psmt.close();
			con.close();*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;//존재하지 않는 아이디
	}
	

}
