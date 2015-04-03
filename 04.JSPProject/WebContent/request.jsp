<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    	<title>JSP/Servlet Example</title>
    </head>
    
    <body>
    <h1>request 객체</h1>
    <hr>
    <table border="1">
    	<tr>
    		<td><%=request.getContextPath() %></td>
    		<td>getContextPath()</td>
    	</tr>
    	<tr>
    		<td><%=request.getMethod() %></td>
    		<td>getMethod()</td>
    	</tr>
    	<tr>
    		<td><%=request.getRequestURL() %></td>
    		<td>getRequestURL() </td>
    	</tr>
    	<tr>
    		<td><%=request.getRequestURI() %></td>
    		<td>getRequestURI() </td>
    	</tr>
    	<tr>
    		<td><%=request.getRemoteHost() %></td>
    		<td>getRemoteHost() </td>
    	</tr>
    	<tr>
    		<td><%=request.getRemoteAddr() %></td>
    		<td>getRemoteAddr() </td>
    	</tr>
    	<tr>
    		<td><%=request.getServerName() %></td>
    		<td>getServerName() </td>
    	</tr>
    	<tr>
    		<td><%=request.getProtocol() %></td>
    		<td>getProtocol() </td>
    	</tr>
    </table>
    
    </body>
    </html>