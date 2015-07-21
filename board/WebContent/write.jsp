<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="Insert.do" method="post" enctype="multipart/form-data" onsubmit="return formCheck();">
	제목:<input type="text" name="title"/><br/>
	작성자:<input type="text" name="writer"/><br/>
	내용:<input type="text" name="content"/><br/>
	첨부파일:<input type="file" name="filename"><br/>
	<input type="submit"/>
	<input type="reset" value="취소">
</form>

<script>
	function formCheck(){
		var title = document.forms[0].title.value;
		var content = document.forms[0].content.value;
		var writer = document.forms[0].writer.value;
		
		if(title == null || title == ""){
			alert('제목을 입력하세요');
			document.forms[0].title.focus();
			return false;
		}
		if(writer == null || writer == ""){
			alert('작성자를 입력하세요');
			document.forms[0].writer.focus();
			return false;
		}
	}
</script>

</body>
</html>