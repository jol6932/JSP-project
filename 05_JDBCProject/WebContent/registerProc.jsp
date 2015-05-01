<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
    <%@page import="java.io.*" %>
    <%
    request.setCharacterEncoding("UTF-8");//POST 방식일때 한글 처리
    
    //0.요청처리
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    String name = request.getParameter("name");
    String age = request.getParameter("age");
    String adr = request.getParameter("adr");
    String gender = request.getParameter("gender");
    
    
    //1.JDBC 드라이버 로드
    Class.forName("oracle.jdbc.driver.OracleDriver"); //ojdbc6.jar 클래스 추가 
    				//패키지이름(oracle~driver)클래스이름(OracleDriver)JDBC 구동하게 해주는 라이브러리
    
    //2.데이터 베이스와 연결
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jspuserc","jsp1234");//서버연결주소,아이디,비밀번호 설정해줘야함
    													//=서버주소						=권한있는 id, pw											
    //getconnection 메소드는 connection타입 return , 기본제공 객체라 new안해도됨
    		
    //3.SQL문 실행
    //1)Statement 객체 이용
    /* String sql = "insert into member values('"+id+"','"+pwd+"','"+name_"',  45,'1','서울시 구로구','2015-04-17')";
    Statement stmt = con.createStatement(); //con 객체 이용해서 statement 생성,sql문이 역할할수있게 해줌
    //제공하는 객체라서 new해주지 않아도 됌.
    int result = stmt.executeUpdate(sql);//executeupdate 는 return 타입 int = 디비에서 영향받은 행 갯수
    			//sql문에서 alt+x누른거랑 같음
    out.print(result);
    */
    //2) PreparedStatement 객체 이용
    String sql = "insert into member values(?,?,?,?,?,?,default)";//사용자가 입력할 값을 일일히 입력하지 않고 ?표시로 대체입력
    PreparedStatement pstmt = con.prepareStatement(sql);
    //받아온 변수랑 변수랑 mapping = 바인딩
    pstmt.setString(1, id);
    //	  set데이터타입(물음표 중에 1번째,변수이름)
    pstmt.setString(2, pwd);
    pstmt.setString(3, name);
    pstmt.setInt(4, Integer.parseInt(age));//String(참조형)->int(기본형) : 형변환 할때 Integer.parseInt(age) 써줘야함
    pstmt.setString(5, gender);
    pstmt.setString(6, adr);
    
    int result = pstmt.executeUpdate();//executeUpdate() == insert,delete,update 문 실행할떄
    out.print(result);
   
    //4.DB연결 끊기
    pstmt.close();
    
    con.close();
    
    %>
    <!DOCTYPE html>
    <html>
    <head>
    	<title>JSP/Servlet Example</title>
    </head>
    
    <body>
    
    </body>
    </html>