<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!-- 페이지 지시자 import 할때 많이씀-->
<%@page import="java.io.*" %>★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆


<%@page errorPage="error.jsp" %><!-- 에러가 나면 에러메세지로 이동하게 설정 -->

    <!DOCTYPE html>
    <html>
    <head>
    	<title>JSP/Servlet Example</title>
    </head>

    <body>
<%= abs(-20)%> 
<%=2/0 %>
<% File f = new File("abs.txt"); %>   
<%!
	String str = "Hello"; //더뒤에 선언을 가능하게 해줌   
	public int abs(int n){
		if(n<0)
			n=-n;
		return n;
	}
%>
    </body>
    </html>