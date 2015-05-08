<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="exam.dao.*" %>
    <%@page import="exam.dto.*" %>
    
    <%
    
		request.setCharacterEncoding("UTF-8");//POST 방식일때 한글 처리
    
    //0.요청처리
    	String id = request.getParameter("id");
    	String pwd = request.getParameter("pwd");
    	String name = request.getParameter("name");
    	String age = request.getParameter("age")
    	String adr = request.getParameter("adr");
   		String gender = request.getParameter("gender");
   		 
   		Member member = new Member();
   		
   		member.setId(id);
   		member.setAddr(adr);
   		member.setAge(Integer.parseInt(age));
   		member.setGender(gender);
   		member.setName(name);
   		member.setPass(pwd);
   		
    	MemberDao dao = new MemberDao();//import 해줘야함
    	
    	dao.insertMember();
    %>
    <!DOCTYPE html>
    <html>
    <head>
    	<title>JSP/Servlet Example</title>
    </head>
    
    <body>
    
    </body>
    </html>