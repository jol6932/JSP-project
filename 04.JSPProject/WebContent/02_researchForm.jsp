<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    	<title>설문 조사</title>
    </head>
    	<h2>설문 조사</h2>
    	<form method="post" action="02_research.jsp">
    	<table border=2>
    	<tr>
    		<td>
    			이름
    		</td>
    		<td>
    			<input type = "text" name = "name">
    		</td>
    	</tr>
    		 	
    	<tr>
    		<td>
    			성별
    		</td>   
    		<td>
    			<input type="radio" name = gender value="male">남자
    			<input type="radio" name = gender value="female">여자
    		</td>
    	</tr>
    	
    	<tr>
    		<td>
    			계절
    		</td>
    		<td>
    			<input type="checkbox" name="season" value="spring">봄
    			<input type="checkbox" name="season" value="summer">여름 
    			<input type="checkbox" name="season" value="fall">가을
    			<input type="checkbox" name="season" value="winter">겨울   			
    		</td>
    	</tr>
    	
    	<tr>
    		<td colspan="2" align="center">
    			<input type="submit" value="전송">
    			<input type="reset" value="취소">
    		</td>
    		
    	</tr>
    	
    	</table>
    	</form>
    
    <body>
    
    </body>
    </html>