<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
    <!DOCTYPE html>
    <html>
    <head>
    	<title>JSP/Servlet Example</title>
    </head>
    
    <body>
    	<h1>ErrorErrorErrorErrorErrorErrorErrorErrorError</h1>
    	<%= exception.getMessage() %><!-- exception=내장객체,<%@ page isErrorPage="true" %>가없으면 사용못함 -->
    </body>
    </html>