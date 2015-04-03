<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    	<title>설문조사 결과</title>
    </head>
    
    <body>
    	<h2>설문조사 결과</h2>
    	<%
    		request.setCharacterEncoding("UTF-8");
    		String name = request.getParameter("name");
    		out.println("이름 : "+name);
    		
    		String gender = request.getParameter("gender");
    		out.print("성별 : ");
    		if(gender.equals("male")){
    			out.println("남자");
    			response.sendRedirect("http://www.naver.com");//리다이렉트 방식으로 페이지 강제이동
    		}
    		if(gender.equals("female")){
    			out.println("여자");
    			response.sendRedirect("http://www.daum.net");
    		}
    		
    		out.print("계절 : ");
    		String season[] = request.getParameterValues("season");
    		for(int i=0;i<season.length;i++)
    		{
    			if(season[i].equals("spring"))
    				out.println("봄");
    			else if(season[i].equals("summer"))
    				out.println("여름");
    			else if(season[i].equals("fall"))
    				out.println("가을");
    			else if(season[i].equals("winter"))
    				out.println("겨울");
    		}
    		
    	
    	%>
    </body>
    </html>