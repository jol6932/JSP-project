<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  firstPage.jsp -->
    <%
    //1.page 영역
    pageContext.setAttribute("page", "pageScope");
    //2.request 영역
    request.setAttribute("request", "requestScope");
 	 //2.session 영역
    session.setAttribute("session", "sessionScope");
 	 //2.application 영역
    application.setAttribute("application", "applicationScope");
    
    
    
    //페이지 이동
    //1.리다이렉트 방식
    response.sendRedirect("secondPage.jsp");
    //2.포워드 방식
    /* RequestDispatcher requestDispatcher = request.getRequestDispatcher("secondPage.jsp");
    
    requestDispatcher.forward(request, response); */
    %>
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
    