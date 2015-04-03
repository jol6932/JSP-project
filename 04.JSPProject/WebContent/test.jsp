<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--JSP주석 <% //자바 주석%>--%>
    <!-- HTML주석 -->
    
<%
	
	int num1=10,num2=20;
	int num3=num1+num2;
	
	out.print(num3);
    
%>
    
    <!DOCTYPE html>
    <html>
    <head>
    	<title>JSP/Servlet Example</title>
    </head>
    
    <body>
    
    </body>
    <%
    out.print("Hello");
    %>
    <%="HELLO" %>
    </html>