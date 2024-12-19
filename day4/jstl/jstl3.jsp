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
<h3 style=color:${one}> ${one } - ${vs.current }</h3>
</c:forEach>


</body>
</html>