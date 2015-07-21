<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.regex.Pattern"%>
<%@page import = "java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<%
String idx = request.getParameter("idx");
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");  //JSP는 예외처리 안해도 자동으로 해주지만 서블릿은 수동으로 해줘야함
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jspuserc","jsp1234");
	//db url,포트,sid,계정정보

	Statement stmt = con.createStatement();
	
	String sql = "delete from boarddb where idx="+idx;
	
	stmt.execute(sql);
	response.sendRedirect("list.do");
	con.close();
	%>
<body>

</body>
<%
}catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
	%>
</html>