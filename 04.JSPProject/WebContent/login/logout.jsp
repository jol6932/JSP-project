<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	session.removeAttribute("loginId");
    	session.invalidate();//일일히 remove를 안해줘도 session값 초기화
    	response.sendRedirect("main.jsp");
    %>
    
    
    
    
    <!DOCTYPE html>
    <html>
    <head>
    	<title>JSP/Servlet Example</title>
    </head>
    
    <body>
    
    </body>
    </html>