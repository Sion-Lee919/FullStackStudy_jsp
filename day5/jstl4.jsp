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
<c:url var="a" value="/images/americano.jpg" /><br>
<c:set var="b" value="/images/americano.jpg"/><br>

<img src="${a }"><br>
<img src="${b }"><br>

<c:url var="other" value="http://www.google.com"/>
<%-- <c:redirect url="${other }"/> --%>

<c:url var="mypage" value ="http://localhost:8070/jsptest/jstl/jstl2.jsp"/>
<c:import url="${mypage }">
	<c:param name="num1" value="100"/>
	<c:param name="num2" value="200"/>
</c:import>
<p>
https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=spring
</p>
<c:url var="naverURL" value="https://search.naver.com/search.naver">
	<c:param name="where" value="nexearch"/>
	<c:param name="sm" value="top_hty"/>
	<c:param name="fbm" value="0"/>
	<c:param name="ie" value="utf8"/>
	<c:param name="query" value="spring"/>
</c:url>

<p style="color: blue;"> ${naverURL }</p>

<c:import var="result" url="${naverURL }" />
<p>${result }</p>

</body>
</html>