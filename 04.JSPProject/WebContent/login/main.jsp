<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    	<title>JSP/Servlet Example</title>
    </head>
    
    <body>
    <h1>환영합니다</h1>
    <hr>
    <%
    String id =(String) session.getAttribute("loginId");//Object 타입 -> String
    %>
    <%
    if(id == null)
    	response.sendRedirect("loginForm.jsp");
    else{%>
    <font color="hotpink"><%= id %></font>님 하이요
    
    <form action ="logout.jsp">
    	<input type = "submit" value = "로그아웃">
    </form>
    <a href = "logout.jsp">로그아웃</a>
    </body>
    </html>
    <%}
     %>