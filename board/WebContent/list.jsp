<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.regex.Pattern"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 만들기</title><!-- 윈도우 상단 제목 -->
</head>

<body>
<h1>게시글 리스트</h1>		<!-- 헤드라인 형식의 글씨 표현 -->
<table>
	<tr>				<!-- 행 정의 -->
		<th>번호</th>		<!-- table에서 강조하고 싶은 칼럼 나타낼떄 -->
		<th>제목</th>
		<th>작성자</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>
	<c:forEach items="${articleList}" var="article">
	<tr>
		<td>${article.idx}</td>
		<td><a href='count.do?idx=${article.idx}'>${article.title}</a></td>
		<td>${article.writer}</td>
		<td>${article.regdate}</td>
		<td>${article.ct}</td>

	</tr>
	</c:forEach>
</table>
<c:if test="${page>0}">
	<a href="list.do?page=${page-10}">이전페이지</a>
</c:if>
<c:if test="${page==0}">
	<a href="list.do?page=${page-10}">이전페이지</a>
</c:if>

<fmt:parseNumber value="${page/10+1}" type="number" integerOnly="True"/>페이지

<c:if test="${fn:length( articleList )<10}">
	<a href="#">다음페이지</a>
</c:if>
<c:if test="${fn:length( articleList )==10}">
	<a href="list.do?page=${page+10}">다음페이지</a>
</c:if>



<a href="write.jsp">글쓰기</a>



</body>
</html>