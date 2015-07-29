<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1>로그인/회원가입</h1>
<form method="post" action="LoginAction">
	아이디:<input type="text" id="id" name="id"/><br/>
	비밀번호:<input type="password" id="password" name="password"/><br/>
	<button input type="submit">로그인</button>
	<input type="button" value="회원가입" onclick="location.href='register.jsp'"/>

</form>

</body>

</html>