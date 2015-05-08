package exam.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //JSP는 예외처리 안해도 자동으로 해주지만 서블릿은 수동으로 해줘야함
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //ojdbc6.jar 클래스 추가 
	    				//패키지이름(oracle~driver)클래스이름(OracleDriver)JDBC 구동하게 해주는 라이브러리
	    
	    //2.데이터 베이스와 연결
	    Connection con = null;
	    //try 안에 있는 객체는 try 안에서 밖에 사용할 수 없으므로 선언은 밖에서 해줌
	    try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jspuserc","jsp1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//서버연결주소,아이디,비밀번호 설정해줘야함
	    //Connection 쓰려면 IMPORT 해줘야함 	
	    PreparedStatement pstmt = null;
	    
	    String sql = "select * from member where id=?";
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				out.print("<h1>회원 상세페이지</h1>");
				
				out.print("<table border=1>");

				out.print("<tr>");
				out.print("<td>아이디</td>");
				out.print("<td>"+rs.getString("id")+"</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>이름</td>");
				out.print("<td>"+rs.getString("name")+"</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>성별</td>");
				out.print("<td>"+rs.getString("gender")+"</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>나이</td>");
				out.print("<td>"+rs.getString("age")+"</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>주소</td>");
				out.print("<td>"+rs.getString("addr")+"</td>");
				out.print("</tr>");
				
				out.print("</table>");
				
				out.print("<a href='delete.jsp?id=" + rs.getString("id")+"'>삭제</a>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		out.print(id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
