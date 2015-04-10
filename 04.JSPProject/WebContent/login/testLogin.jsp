<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    
    
    if(id.equals("test") && pwd.equals("1234")){
    	out.print("로그인 성공");
    	session.setAttribute("loginId", id);//로그인은 세션영역에서 사용(같은 브라우저에서 페이지 이동을 해도 사용할수 있게)
    	//로그인 후에 main및 다른 페이지에서도 유지해야 하니까
    	response.sendRedirect("main.jsp");
    }
    else{
    	out.print("로그인 실패");
    	response.sendRedirect("loginForm.jsp");
    }
    %>
    <!DOCTYPE html>
    <html>
    <head>
    	<title>JSP/Servlet Example</title>
    </head>
    
    <body>
    
    </body>
    </html>