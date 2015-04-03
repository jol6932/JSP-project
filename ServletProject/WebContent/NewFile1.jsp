<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    	<title>JSP/Servlet Example</title>
    	<style>
    	body{
    		background-image:url("back.png");
    		//background-repeat:no-repeat;
    		background-attachment:fixed;
    	}
    	input, select, textarea{
    		border:blue 1pt solid;
    		color:red;
    		font-size:20px;

    	}
    	</style>
    	<script>
    		function gofunc(){
    			alert("Hello JavaScript");
    		}
    	</script>
    </head>
    
    <body>
    <h1>request test</h1>
    <hr>
    
    <form action="TestServlet" onsubmit="reutrn gofunc()"><!-- submit 버튼 누르면 gofunc()함수 호출 -->
    	<label for="id">이름 : </label><input type="text" id="id" name = "A"><br>
    	<label for="pw">비번 : </label><input type="password" id = "pw" name = "passwd"><br>
    	
    	<input type="radio" name = "gender" value = "남자">남자
    	<input type="radio" name = "gender" value = "여자">여자 <br>
    	
    	<input type="checkbox" name = "hb" value="축구">축구
    	<input type="checkbox" name = "hb" value="야구">야구
    	<input type="checkbox" name = "hb" value="농구">농구
    	<input type="checkbox" name = "hb" value="배구">배구<br> 
    	<!-- name을 똑같이 줘야 getParameterValues 이용 가능 -->
    	
    	<input type="date" name="date"><br>
    	<select name="select">
    	
    	<option value = "java">Java</option>
    	<option value = "jsp">JSP</option>
    	<option value = "html">HTML</option>
    	
    	</select>
    	<textarea rows="70" cols="15" name = "text"> 	
    	</textarea><br>
    	
    	<input type="color" name = "mycolor"><br>
    	<input type="email" name = "mail"><br>
    	
    	<input type="submit" value="서버로 제출">
    </form>
    </body>
    </html>