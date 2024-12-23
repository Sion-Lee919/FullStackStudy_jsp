<%@page import="mvc.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.getAttribute("boardlist"); %>
<h1>${param.page }페이지의 게시물목록입니다</h1>
<table border="2">
<tr><th>번호</th><th>제목</th><th>작성자</th><th>조회수</th></tr>
<c:forEach items="${boardlist }" varStatus="vs">
	<tr><td>${ vs.current.number}</td><td><a href='boardstart?menu=boarddetail&seq=${ vs.current.number}'>${ vs.current.title}</a></td>
	<td>${ vs.current.writer}</td><td>${ vs.current.viewcount}</td></tr>
</c:forEach>
</table>

 <h1>총 페이지는 ${allpage } 입니다</h1>
 <%int count2=0; %>
<c:forEach begin="1" end="${allpage/count }">
	<%count2++; %>
	<span><a href='boardstart?menu=boardlist&page=<%=count2%>'><%=count2 %></a></span>
</c:forEach>
	<span><a href='boardstart?menu=boardlist&page=<%=count2+1%>'><%=count2+1 %></a></span>

<%
int totalcount = (Integer) request.getAttribute("allpage");
int count1 = (Integer) request.getAttribute("count");

int totalpage = 0;
if(totalcount %count1 ==0){
	totalpage = totalcount /count1;
}
else {
	totalpage = totalcount/count1+1;
}
for(int i=1; i<=totalpage; i++){
%>	
	<a href='boardstart?menu=boardlist&page=<%=i %>'><%=i %>페이지</a>
<% 
}
%>



<form action="boardstart?menu=boardstart" method="post">
<input type="submit" value="첫화면으로 가기">
</form>
</body>
</html>