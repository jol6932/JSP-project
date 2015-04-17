<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
    <%
    
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    
    
    //1.JDBC 드라이버 로드
    Class.forName("oracle.jdbc.driver.OracleDriver"); //ojdbc6.jar 클래스 추가
    
    //2.데이터 베이스와 연결
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jspuserc","jsp1234");//서버연결주소,아이디,비밀번호 설정해줘야함
    //getconnection 메소드는 connection타입 return , 기본제공 객체라 new안해도됨
    		
    //3.SQL문 실행
    String sql = "insert into member values('"+id+"','"+pwd+"','컹컹이',45,'1','서울시 구로구','2015-04-17')";
    Statement stmt = con.createStatement(); //con 객체 이용해서 statement 생성,sql문이 역할할수있게 해줌
    int result = stmt.executeUpdate(sql);//executeupdate 는 return 타입 int = 디비에서 영향받은 행 갯수
    out.print(result);
    //4.DB연결 끊기
    stmt.close();
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