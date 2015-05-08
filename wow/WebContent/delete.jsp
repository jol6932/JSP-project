<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
    <%@page import="java.io.*" %>
    
    <%
    String sql = "delete member where id = ?";
    String id = request.getParameter("id");
    
    Class.forName("oracle.jdbc.driver.OracleDriver");
    
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jspuserc","jsp1234");
    
    PreparedStatement pstmt = con.prepareStatement(sql);
    
    pstmt.setString(1, id);
    
    int result = pstmt.executeUpdate();
    
    if(result==1)
    	response.sendRedirect("list");
    %>
    <!DOCTYPE html>
    <html>
    <head>
    	<title>JSP/Servlet Example</title>
    </head>
    
    <body>
    
    </body>
    </html>