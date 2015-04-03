<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    	<title>JSP/Servlet Example</title>
    </head>
    
    <body>
    	<h1>application 객체</h1>
    	<table border="1">
    	<tr>
    		<td><%= application.getContextPath()%></td>
    		<td>getContextPath()</td>
    	</tr>
    	<tr>
    		<td><%=application.getServerInfo() %></td>
    		<td>getServerInfo()</td>
    	</tr>
    	<tr>
    		<td><%=application.getRealPath(".") %></td>
    		<td>getRealPath()</td>
    	</tr>
    	</table>
    </body>
    </html>