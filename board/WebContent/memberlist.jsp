<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.member.Member" %>
<%@ page import="board.dao.MemberDao" %>
<%@ page import="java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 리스트</h1>

<a href='LogoutAction'>로그아웃</a>
<a href="list.do">글목록</a>

<table border=1>
<tr>
	<th>아이디</th>
	<th>이름</th>
	<th>주소</th>
	<th>성별</th>
	<th>나이</th>
	<th>등록일</th>
	<th>삭제</th>
</tr>
<%
@SuppressWarnings("unchecked")
List<Member> list = (List<Member>)request.getAttribute("list");


for(int i=0;i<list.size();i++){
	Member member = list.get(i);
	
%>
<tr>
	<td><%=member.getId() %></td>
	<td><%=member.getName() %></td>
	<td><%=member.getAddr() %></td>
	<td><%=member.getGender()%></td>
	<td><%=member.getAge() %></td>
	<td><%=member.getMregdate() %></td>
	<td><a href='DeleteMember?id=<%=member.getId() %>'>삭제</a></td>
	</tr>
	<%} %>
	

	
</table>
<!-- 페이징 -->
<%
MemberDao dao = new MemberDao();
int amountmem=dao.Paging();//총게시글 수

int firstpage;

int amountpage=amountmem/5;//한페이지에 5개씩 나눴을때 페이지 갯수

if(amountmem%5>0) //5개씩 나누었을때 나머지가 생기면 한페이지 추가
	amountpage++;

int apage = Integer.parseInt(request.getParameter("apage"));
if(apage>10){
if(apage%10==0)
	firstpage=((apage/10)*10)-9;
else
	firstpage=((apage/10)*10)+1;
}
else
	firstpage=1;

 if(apage<=10)
	 firstpage=1;
int lastpage=firstpage+9;

if(lastpage>amountpage)
	lastpage=amountpage;

out.println(firstpage+","+lastpage);
%>
<a href="MemberList?apage=1">처음으로</a>
<%if(firstpage>10){	%>
<a href="MemberList?apage=<%=firstpage-10%>">이전</a>
<%}
for(int i=firstpage;i<=lastpage;i++){
%>
<a href="MemberList?apage=<%=i%>"><%=" "+i+" " %></a>
<%} 
if(amountpage>10&&lastpage<amountpage){
%>
<a href="MemberList?apage=<%=firstpage+=10%>">다음</a>
<%}
if(amountpage!=apage){%>
<a href="MemberList?apage=<%=amountpage%>">끝으로</a>
<%}%>

</body>
</html>