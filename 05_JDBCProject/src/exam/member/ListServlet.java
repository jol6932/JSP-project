package exam.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/list")//URL mapping 
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//URL에 ~~~/list 를 치면 실행되게 할것 이므로 do get에다가 작성
		//1.JDBC 드라이버 로드
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
	    //Connection 쓰려면 IMPORT 해줘야함 							=서버주소						=권한있는 id, pw
	    
	    
	    //3.SQL문 실행
	    String sql = "select * from member";
	    PreparedStatement pstmt = null;//pstmt가 try 안에 있으므로 선언은 try 밖에서 선언
	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter(); //out 내장객체가 없으니까 만들어줘야함
	    
	    try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();//ResultSet = select문 결과값 저장하는 데이터타입
			//선언하면 커서단위로 처리하는데 맨1번째 커서 전 커서로 가리키고 있음(존재하지않는 0번째)
			out.print("<table border=1>");
			while(rs.next()){//rs.next = 다음 커서로 이동함 Return type boolean -> 다음줄로 이동했는데 데이터가 있으면 true,없으면 false
				String gd = null;
				if(rs.getString("gender").equals("m"))
					gd = "남자";
				else if(rs.getString("gender").equals("f"))
					gd = "여자";
					
				out.print("<tr>");
				out.print("<td>" +rs.getString("id")+"</td>");//데이터를 가져올때는 컬럼별로 가져와야함
				out.println("<td>" +rs.getString("name")+"</td>");
				out.println("<td>" +rs.getString("age")+"</td>");
				out.println("<td>" +rs.getString("addr")+"</td>");
				out.println("<td>" +gd+"</td>");
			}
			out.print("<table>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	   
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	

}

