<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  secondPage.jsp -->
    
    <!DOCTYPE html>
    <html>
    <head>
    	<title>JSP/Servlet Example</title>
    </head>
    
    <body>
    <h1>두번째 페이지</h1>
    <hr>
    page영역 : <%= pageContext.getAttribute("page") %> <br>
    request영역 : <%= request.getAttribute("request") %> <br>
    session영역 : <%= session.getAttribute("session") %> <br>
    application영역 : <%= application.getAttribute("application") %> <br>
    </body>
    </html>
    