<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.regex.Pattern"%>
<%@page import = "java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import = "board.beans.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
	function onDownload(idx){
		var o = document.getElementById("ifrm_filedown");
		o.src="download.do?idx="+idx;
	}
</script>
</head>

<%
	Board board = new Board();
	board = (Board) request.getAttribute("article");
%>
<!-- JSTL을 이용하여 HTML와 <% %>스크립트트릿 이원화 -->
<body>
<iframe id = "ifrm_filedown" style="position:absolute; z-index:1;visibility : hidden;"></iframe>
<h1>게시글 조회</h1>
<table border="1">
	<tr>
		<th>글번호</th>
		<td><%=board.getIdx()%></td>
		<th>작성자</th>
		<td><%=board.getWriter() %></td>
		<th>작성일</th>
		<td><%=board.getRegdate() %></td>
		<th>조회수</th>
		<td>${article.ct}</td>
	</tr>
	<tr>
		<th colspan="2">제목</th><!-- colspan:행병합 속성 -->
		<td colspan="6"><%=board.getTitle() %></td>
	</tr>
	<tr>
		<th colspan="2">내용</th>
		<td colspan="6"><%=board.getContent() %></td>
	</tr>
	<tr>
		<th colspan="2">첨부파일</th>
		<td colspan="8">
		<a href="#" onclick="onDownload('${article.idx}')">${article.filename}</a>
		</td>
		
	</tr>
</table>
<a href="delete.jsp?idx=<%=board.getIdx()%>&writer=<%=board.getWriter()%>">삭제</a>
<a href="list.do">글목록</a>

</body>
</html>