<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.regex.Pattern"%>
<%@page import = "java.sql.*" %>
<%@page import = "javax.servlet.http.HttpSession"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<%
session = request.getSession();
String idx = request.getParameter("idx");
String writer = request.getParameter("writer");
String sid = (String)session.getAttribute("id");

if(writer.equals(sid)||sid.equals("admin")){//글쓴이와 현재 접속한 아이디가 일치하면 글삭제 가능
	try{
		
		
		String sql = "delete from boarddb where idx="+idx;
		Class.forName("oracle.jdbc.driver.OracleDriver");  //JSP는 예외처리 안해도 자동으로 해주지만 서블릿은 수동으로 해줘야함
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jspuserc","jsp1234");
		//db url,포트,sid,계정정보
	
		Statement stmt = con.createStatement();
		
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
}
else{
	out.print("<script>");
	out.print("alert('권한이 없습니다.');");
	out.print("location.href='list.do';");
	out.print("</script>");
}

	%>
</html>