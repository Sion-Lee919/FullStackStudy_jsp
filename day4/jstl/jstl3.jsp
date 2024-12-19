<%@page import="java.util.HashMap"%>
<%@page import="java.util.HashSet"%>
<%@page import="dto.MemberDTO"%>
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
<!-- el 컬렉션 사용 -->
<c:forEach begin="1" end="10" step="1" var="num">
	<c:set var="sum" value="${ sum+num}"/>
	<h3>지금까지의 합계출력= ${sum }</h3>
</c:forEach>
<h3>반복 종료이후 합계출력=${sum}</h3>

<%String array[] = {"red","black","white","green","blue","yellow"}; %>
<%-- <h1>배열접근1 </h1> 
<c:forEach items="<%= array %>" var="one">
<h3 style=color:${one}> ${one }</h3>
</c:forEach>

<h1>배열접근2 </h1> 
<c:set var = "colors" value = "<%= array %>"/>
<c:forEach items="${colors}" var="one">
<h3 style=color:${one}> ${one }</h3>
</c:forEach>
 --%>

<h1>배열접근3 </h1> 
<c:set var = "colors" value = "<%= array %>"/>
<c:forEach items="${colors}" var="one" varStatus="vs">
<c:if test="${vs.first || vs.last }">
<h3 style="color:${one};border:2px solid navy">${vs.index }번째 색상 ${one } - ${vs.current } -지금까지의 색상${vs.count } </h3>
</c:if>
<h3 style=color:${one}>${vs.index }번째 색상 ${one } - ${vs.current } -지금까지의 색상${vs.count } </h3>
</c:forEach>



<jsp:useBean id="list" class="java.util.ArrayList"/>
<%
list.add(new MemberDTO("ID1","회원1",1111,"010-1111-1111",""));
list.add(new MemberDTO("ID1","회원2",1111,"010-1111-1111","")); 
list.add(new MemberDTO("ID1","회원3",1111,"010-1111-1111","")); 
list.add(new MemberDTO("ID1","회원4",1111,"010-1111-1111","")); 
list.add(new MemberDTO("ID1","회원5",1111,"010-1111-1111","")); 
%>
<table border=3>
<c:forEach items="${list }" varStatus="vs1">
	<tr>
	<td>${vs1.current.id }</td>
	<td>${vs1.current.name }</td>
	<td>${vs1.current.pw }</td>
	<td>${vs1.current.phone }</td>
	<td>${vs1.current.email }</td>
	</tr>
</c:forEach>
</table>


<%
HashSet<String> set = new HashSet();
set.add("red"); set.add("blue"); set.add("green");
%>

<c:forEach items="<%=set %>" varStatus="vs">
 	<h3>${vs.current }</h3>
</c:forEach>

<%
HashMap<String,String> map = new HashMap();
map.put("빨강","red");
map.put("주황","orange");
map.put("노랑","yellow");
map.put("초록","green");
map.put("파랑","blue");
map.put("남색","navy");
map.put("보라색","purple");
%>

<c:forEach items="<%=map %>" varStatus="vs">
	<h3>한글색상${vs.current.key } - 영문색상${vs.current.value }</h3>

</c:forEach>

<!-- el ${cookie} - <String(쿠키이름), Cookie 객체("이름","값") -->

<h1>쿠키 읽기</h1>
<c:forEach items="${cookie }" varStatus="vs">
  <h3>쿠키이름 = ${vs.current.key } - 쿠키값 ${vs.current.value.value }</h3>
</c:forEach>


<!-- 토큰읽기 -->
<h1>토큰 읽기</h1>
<%String json="{id:\"json\",name:\"홍길동\",age:20}"; %>
<c:forTokens items="<%=json%>" delims="{}:"," var="data" begin="1" step="2">
  	<h3>${data }</h3>
</c:forTokens>
</body>
</html>
