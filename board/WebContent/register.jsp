<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>
<form action="RegisterAction" method="post">
ID : <input type="text" id="id" name="id"><br/>
PW : <input type="password" id="pwd" name="pwd"><br/>
이름 : <input type="text" id="name" name="name"><br/>
나이 : <input type="number" id = "age" name="age"><br/>
성별 : <input type="radio" name="gender" id="gender" value="m" checked="">남자
<input type="radio" name="gender" id="gender" value="f">여자<br/>
주소 : <input type="text" id="addr" name="addr"><br/>
<button type="submit">가입</button>
<button type="reset">취소</button>
</form>
</body>
</html>