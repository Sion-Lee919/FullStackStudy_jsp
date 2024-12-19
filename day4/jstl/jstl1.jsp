<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- jsp변수를 el변수 변환 -->
<%	
	String id = "jstl1" ;
	int pw = 1234 ;
	pageContext.setAttribute("elid", id);
%>
<h3>jsp변수를 el변수 변환 1 = ${ elid }</h3>

<!-- jsp변수를 el변수 변환 -->
<c:set var="id" value="<%=id %>"/>
<h3>jsp변수를 el변수 변환2 = ${ id }</h3>

<c:set var="pw" value="1234"/>
<h3>el name= ${name = "이자바" }</h3>
<c:set var="name2" value="${name} 회원님"/>
<h3>el name2= ${name2}</h3>

<%-- <c:set var="" value="값<%= %>${ }"> --%>

<!-- 변수 출력 -->
<h3>pw출력 = <c:out value="<a href=''>${pw }</a>" default="변수선언없음" escapeXml="false"></c:out></h3>

<!-- 변수 삭제 -->
<c:remove var="pw"/>
<h3>pw출력(삭제후) = <c:out value="<a href=''>${pw }</a>" default="변수선언없음" escapeXml="false"></c:out></h3>

<% request.getRemoteAddr();%>
<c:set var="clientip" value="${pageContext.request.remoteAddr }"/>

<c:remove var="clientip"/>

<h3>요청 클라이언트 id = ${empty clientip?"ip삭제":clientip }</h3>
<c:if test="${!empty clientip}">
	<h3>요청클라이언트ip=${clientip }</h3>
</c:if>

<c:if test="${empty clientip}">
	<h3>ip삭제</h3>
</c:if>

<c:if test="<%=10>5 %>">
	<h3>10은 5보다 크다</h3>
</c:if>

<!-- choose 태그 -->
<c:choose>
<c:when test="${!empty clientip}">
	<h3>요청클라이언트ip(choose 태그)=${clientip }</h3>
</c:when>
<c:otherwise>
<h3>(choose 태그)ip삭제</h3>
</c:otherwise>
</c:choose>


<c:if test="${empty clientip}">
	<h3>ip삭제</h3>
</c:if>




</body>
</html>